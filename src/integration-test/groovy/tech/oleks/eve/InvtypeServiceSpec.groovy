package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InvtypeServiceSpec extends Specification {

    InvtypeService invtypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Invtype(...).save(flush: true, failOnError: true)
        //new Invtype(...).save(flush: true, failOnError: true)
        //Invtype invtype = new Invtype(...).save(flush: true, failOnError: true)
        //new Invtype(...).save(flush: true, failOnError: true)
        //new Invtype(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //invtype.id
    }

    void "test get"() {
        setupData()

        expect:
        invtypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Invtype> invtypeList = invtypeService.list(max: 2, offset: 2)

        then:
        invtypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        invtypeService.count() == 5
    }

    void "test delete"() {
        Long invtypeId = setupData()

        expect:
        invtypeService.count() == 5

        when:
        invtypeService.delete(invtypeId)
        sessionFactory.currentSession.flush()

        then:
        invtypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Invtype invtype = new Invtype()
        invtypeService.save(invtype)

        then:
        invtype.id != null
    }
}
