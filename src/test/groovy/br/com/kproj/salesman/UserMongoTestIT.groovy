package br.com.kproj.salesman

import br.com.kproj.salesman.administration.users.infrastructure.persistence.springdata.AddressMongo
import br.com.kproj.salesman.administration.users.infrastructure.persistence.springdata.UserMongo
import br.com.kproj.salesman.administration.users.infrastructure.persistence.springdata.UserMongoRepository
import br.com.kproj.salesman.infratest.AbstractIntegrationTest
import com.google.common.collect.Lists
import com.mongodb.WriteResult
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Unroll

class UserMongoTestIT extends AbstractIntegrationTest {


    MockMvc mockMvc

    @Autowired
    WebApplicationContext webApplicationContext

    @Autowired
    UserMongoRepository repository

    @Autowired
    MongoTemplate template


    def setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build()
    }

    @Unroll
    "Should find all addresses by customer using paginated"() {
        given:
            def userOne = new UserMongo("Jhon 1", "Travolta 1", new Date())
            def userTwo = new UserMongo("Joao Primeiro", "Indo One", new Date())
        when:

//            Query query = new Query(Criteria.where("addresses.id").is(new ObjectId("58b70606bdeb4a449529a73d")))
//            query.fields().include("addresses.\$")
//
//            def updateAddress = new Update().set("addresses.\$.street", "SET Street 10")
//                                            .set("addresses.\$.city", "PP")
//
//            def result = template.findAndModify(query, updateAddress, FindAndModifyOptions.options().returnNew(Boolean.TRUE), UserMongo)

//            def user = template.findOne(query, UserMongo.class)
//            user.setBirth(new Date())
//            user.setName("Marcelo")
//            user.setLastName("Maico")
//            template.save(user)
            userOne.addresses.add(new AddressMongo("Street Teste", "City Teste"))
            userOne.addresses.add(new AddressMongo("Street Teste 2", "City Teste 2"))

            userTwo.addresses.add(new AddressMongo("Street One", "City One"))
            userTwo.addresses.add(new AddressMongo("Street Two", "City Two"))
            userTwo.addresses.add(new AddressMongo("Street Three", "City Three"))


            template.save(userOne)
            template.save(userTwo)
            def all = template.findAll(UserMongo.class)

            System.out.println("####################################")
            //System.out.println(result)
            //System.out.println("UPDATE QUERY: " + updateAddress)
        then:
            all == null
    }


}
