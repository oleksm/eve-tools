package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MapsolarsystemServiceSpec extends Specification {

    MapsolarsystemService mapsolarsystemService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mapsolarsystem(...).save(flush: true, failOnError: true)
        //new Mapsolarsystem(...).save(flush: true, failOnError: true)
        //Mapsolarsystem mapsolarsystem = new Mapsolarsystem(...).save(flush: true, failOnError: true)
        //new Mapsolarsystem(...).save(flush: true, failOnError: true)
        //new Mapsolarsystem(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mapsolarsystem.id
    }

    void "test get"() {
        setupData()

        expect:
        mapsolarsystemService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mapsolarsystem> mapsolarsystemList = mapsolarsystemService.list(max: 2, offset: 2)

        then:
        mapsolarsystemList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mapsolarsystemService.count() == 5
    }

    void "test delete"() {
        Long mapsolarsystemId = setupData()

        expect:
        mapsolarsystemService.count() == 5

        when:
        mapsolarsystemService.delete(mapsolarsystemId)
        sessionFactory.currentSession.flush()

        then:
        mapsolarsystemService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mapsolarsystem mapsolarsystem = new Mapsolarsystem()
        mapsolarsystemService.save(mapsolarsystem)

        then:
        mapsolarsystem.id != null
    }
}
