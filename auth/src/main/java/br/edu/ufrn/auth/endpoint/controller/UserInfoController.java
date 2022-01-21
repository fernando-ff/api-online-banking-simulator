package br.edu.ufrn.auth.endpoint.controller;

import br.edu.ufrn.core.model.User;
import io.swagger.annotations.Api;
import br.edu.ufrn.auth.endpoint.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

/**
 * @author William Suane
 */
@RestController
@RequestMapping("user")
@Api(value = "Endpoints to manage User's information")
public class UserInfoController {

    @Autowired
    private UserService userSerice;

    @GetMapping(path = "info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Will retrieve the information from the user available in the token", response = User.class)
    public ResponseEntity<User> getUserInfo(Principal principal) {
        User applicationUser = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return new ResponseEntity<>(applicationUser, HttpStatus.OK);
    }

	@PostMapping("/save")
    public ResponseEntity<User> getUserInfo(@RequestBody User user) {
        User userSave = userSerice.save(user);
        return new ResponseEntity<>(userSave, HttpStatus.OK);
    }
}
