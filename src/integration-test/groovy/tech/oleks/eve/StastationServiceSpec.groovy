package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StastationServiceSpec extends Specification {

    StastationService stastationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Stastation(...).save(flush: true, failOnError: true)
        //new Stastation(...).save(flush: true, failOnError: true)
        //Stastation stastation = new Stastation(...).save(flush: true, failOnError: true)
        //new Stastation(...).save(flush: true, failOnError: true)
        //new Stastation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //stastation.id
    }

    void "test get"() {
        setupData()

        expect:
        stastationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Stastation> stastationList = stastationService.list(max: 2, offset: 2)

        then:
        stastationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        stastationService.count() == 5
    }

    void "test delete"() {
        Long stastationId = setupData()

        expect:
        stastationService.count() == 5

        when:
        stastationService.delete(stastationId)
        sessionFactory.currentSession.flush()

        then:
        stastationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Stastation stastation = new Stastation()
        stastationService.save(stastation)

        then:
        stastation.id != null
    }
}
