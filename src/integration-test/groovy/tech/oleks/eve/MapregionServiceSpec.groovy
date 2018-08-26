package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MapregionServiceSpec extends Specification {

    MapregionService mapregionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mapregion(...).save(flush: true, failOnError: true)
        //new Mapregion(...).save(flush: true, failOnError: true)
        //Mapregion mapregion = new Mapregion(...).save(flush: true, failOnError: true)
        //new Mapregion(...).save(flush: true, failOnError: true)
        //new Mapregion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mapregion.id
    }

    void "test get"() {
        setupData()

        expect:
        mapregionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mapregion> mapregionList = mapregionService.list(max: 2, offset: 2)

        then:
        mapregionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mapregionService.count() == 5
    }

    void "test delete"() {
        Long mapregionId = setupData()

        expect:
        mapregionService.count() == 5

        when:
        mapregionService.delete(mapregionId)
        sessionFactory.currentSession.flush()

        then:
        mapregionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mapregion mapregion = new Mapregion()
        mapregionService.save(mapregion)

        then:
        mapregion.id != null
    }
}
