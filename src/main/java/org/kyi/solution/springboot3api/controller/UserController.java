package org.kyi.solution.springboot3api.controller;


import lombok.AllArgsConstructor;
import org.kyi.solution.springboot3api.configuration.UserPrincipal;
import org.kyi.solution.springboot3api.domain.HttpResponse;
import org.kyi.solution.springboot3api.exception.CustomExceptionHandler;
import org.kyi.solution.springboot3api.exception.custom.EmailExistException;
import org.kyi.solution.springboot3api.model.User;
import org.kyi.solution.springboot3api.provider.JWTTokenProvider;
import org.kyi.solution.springboot3api.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.kyi.solution.springboot3api.common.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.kyi.solution.springboot3api.domain.HttpResponse.createResponse;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController extends CustomExceptionHandler {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;


    @PostMapping("/login")
    public ResponseEntity<HttpResponse<User>> login(@RequestBody User user) {
        authenticate(user.getEmail(), user.getPassword());
        User loginUser = userService.findUserByEmail(user.getEmail());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return createResponse(loginUser, jwtHeader, OK);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpResponse<User>> register(@RequestBody User user) throws EmailExistException {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return createResponse(newUser, OK);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

}
