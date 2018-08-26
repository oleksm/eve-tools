package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InvflagServiceSpec extends Specification {

    InvflagService invflagService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Invflag(...).save(flush: true, failOnError: true)
        //new Invflag(...).save(flush: true, failOnError: true)
        //Invflag invflag = new Invflag(...).save(flush: true, failOnError: true)
        //new Invflag(...).save(flush: true, failOnError: true)
        //new Invflag(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //invflag.id
    }

    void "test get"() {
        setupData()

        expect:
        invflagService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Invflag> invflagList = invflagService.list(max: 2, offset: 2)

        then:
        invflagList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        invflagService.count() == 5
    }

    void "test delete"() {
        Long invflagId = setupData()

        expect:
        invflagService.count() == 5

        when:
        invflagService.delete(invflagId)
        sessionFactory.currentSession.flush()

        then:
        invflagService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Invflag invflag = new Invflag()
        invflagService.save(invflag)

        then:
        invflag.id != null
    }
}
