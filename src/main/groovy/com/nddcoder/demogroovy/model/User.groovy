package com.nddcoder.demogroovy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import groovy.transform.CompileStatic
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@CompileStatic
@Document(collection = "users")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class User {
    @Id
    ObjectId _id

    String email

    String password

    String name

    Date createdAt

    Date modifiedAt

    String get_id() {
        return _id.toString()
    }
}
