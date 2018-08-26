package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MoonmaterialServiceSpec extends Specification {

    MoonmaterialService moonmaterialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Moonmaterial(...).save(flush: true, failOnError: true)
        //new Moonmaterial(...).save(flush: true, failOnError: true)
        //Moonmaterial moonmaterial = new Moonmaterial(...).save(flush: true, failOnError: true)
        //new Moonmaterial(...).save(flush: true, failOnError: true)
        //new Moonmaterial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //moonmaterial.id
    }

    void "test get"() {
        setupData()

        expect:
        moonmaterialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Moonmaterial> moonmaterialList = moonmaterialService.list(max: 2, offset: 2)

        then:
        moonmaterialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        moonmaterialService.count() == 5
    }

    void "test delete"() {
        Long moonmaterialId = setupData()

        expect:
        moonmaterialService.count() == 5

        when:
        moonmaterialService.delete(moonmaterialId)
        sessionFactory.currentSession.flush()

        then:
        moonmaterialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Moonmaterial moonmaterial = new Moonmaterial()
        moonmaterialService.save(moonmaterial)

        then:
        moonmaterial.id != null
    }
}
