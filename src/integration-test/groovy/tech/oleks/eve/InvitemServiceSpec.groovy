package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InvitemServiceSpec extends Specification {

    InvitemService invitemService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Invitem(...).save(flush: true, failOnError: true)
        //new Invitem(...).save(flush: true, failOnError: true)
        //Invitem invitem = new Invitem(...).save(flush: true, failOnError: true)
        //new Invitem(...).save(flush: true, failOnError: true)
        //new Invitem(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //invitem.id
    }

    void "test get"() {
        setupData()

        expect:
        invitemService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Invitem> invitemList = invitemService.list(max: 2, offset: 2)

        then:
        invitemList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        invitemService.count() == 5
    }

    void "test delete"() {
        Long invitemId = setupData()

        expect:
        invitemService.count() == 5

        when:
        invitemService.delete(invitemId)
        sessionFactory.currentSession.flush()

        then:
        invitemService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Invitem invitem = new Invitem()
        invitemService.save(invitem)

        then:
        invitem.id != null
    }
}
