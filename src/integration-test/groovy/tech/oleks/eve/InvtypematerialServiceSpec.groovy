package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InvtypematerialServiceSpec extends Specification {

    InvtypematerialService invtypematerialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Invtypematerial(...).save(flush: true, failOnError: true)
        //new Invtypematerial(...).save(flush: true, failOnError: true)
        //Invtypematerial invtypematerial = new Invtypematerial(...).save(flush: true, failOnError: true)
        //new Invtypematerial(...).save(flush: true, failOnError: true)
        //new Invtypematerial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //invtypematerial.id
    }

    void "test get"() {
        setupData()

        expect:
        invtypematerialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Invtypematerial> invtypematerialList = invtypematerialService.list(max: 2, offset: 2)

        then:
        invtypematerialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        invtypematerialService.count() == 5
    }

    void "test delete"() {
        Long invtypematerialId = setupData()

        expect:
        invtypematerialService.count() == 5

        when:
        invtypematerialService.delete(invtypematerialId)
        sessionFactory.currentSession.flush()

        then:
        invtypematerialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Invtypematerial invtypematerial = new Invtypematerial()
        invtypematerialService.save(invtypematerial)

        then:
        invtypematerial.id != null
    }
}
