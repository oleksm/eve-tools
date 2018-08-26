package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InvtypereactionServiceSpec extends Specification {

    InvtypereactionService invtypereactionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Invtypereaction(...).save(flush: true, failOnError: true)
        //new Invtypereaction(...).save(flush: true, failOnError: true)
        //Invtypereaction invtypereaction = new Invtypereaction(...).save(flush: true, failOnError: true)
        //new Invtypereaction(...).save(flush: true, failOnError: true)
        //new Invtypereaction(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //invtypereaction.id
    }

    void "test get"() {
        setupData()

        expect:
        invtypereactionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Invtypereaction> invtypereactionList = invtypereactionService.list(max: 2, offset: 2)

        then:
        invtypereactionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        invtypereactionService.count() == 5
    }

    void "test delete"() {
        Long invtypereactionId = setupData()

        expect:
        invtypereactionService.count() == 5

        when:
        invtypereactionService.delete(invtypereactionId)
        sessionFactory.currentSession.flush()

        then:
        invtypereactionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Invtypereaction invtypereaction = new Invtypereaction()
        invtypereactionService.save(invtypereaction)

        then:
        invtypereaction.id != null
    }
}
