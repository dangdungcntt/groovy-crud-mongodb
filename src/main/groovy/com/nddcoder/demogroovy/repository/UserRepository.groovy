package com.nddcoder.demogroovy.repository

import com.nddcoder.demogroovy.model.User
import groovy.transform.CompileStatic
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

@CompileStatic
interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByEmail(String email)
}
