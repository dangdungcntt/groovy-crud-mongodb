package com.nddcoder.demogroovy.controller

import com.nddcoder.demogroovy.exception.ResourceNotFoundException
import com.nddcoder.demogroovy.model.User
import com.nddcoder.demogroovy.repository.UserRepository
import groovy.transform.CompileStatic
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CompileStatic
@RestController
@RequestMapping('users')
class UserController {

    @Autowired
    UserRepository userRepository

    @GetMapping
    List<User> index() {
        return userRepository.findAll()
    }

    @PostMapping
    User store(@RequestBody User user) {
        return userRepository.save(user)
    }

    @GetMapping('/{id}')
    User show(@PathVariable String id) {
        return userRepository.findById(new ObjectId(id))
                .orElseThrow {
                    throw new ResourceNotFoundException("User with id ${id} not exists!")
                }
    }

    @PutMapping('/{id}')
    User update(@PathVariable String id, @RequestBody User updateUser) {
        User user = userRepository.findById(new ObjectId(id))
                .orElseThrow {
                    throw new ResourceNotFoundException("User with id ${id} not exists!")
                }

        updateUser._id = new ObjectId(user._id)

        return userRepository.save(updateUser)
    }

    @DeleteMapping('/{id}')
    void update(@PathVariable String id) {
        User user = userRepository.findById(new ObjectId(id))
                .orElseThrow {
                    throw new ResourceNotFoundException("User with id ${id} not exists!")
                }

        userRepository.delete(user)
    }
}
