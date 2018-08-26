package tech.oleks.eve

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MarketlogServiceSpec extends Specification {

    MarketlogService marketlogService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Marketlog(...).save(flush: true, failOnError: true)
        //new Marketlog(...).save(flush: true, failOnError: true)
        //Marketlog marketlog = new Marketlog(...).save(flush: true, failOnError: true)
        //new Marketlog(...).save(flush: true, failOnError: true)
        //new Marketlog(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //marketlog.id
    }

    void "test get"() {
        setupData()

        expect:
        marketlogService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Marketlog> marketlogList = marketlogService.list(max: 2, offset: 2)

        then:
        marketlogList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        marketlogService.count() == 5
    }

    void "test delete"() {
        Long marketlogId = setupData()

        expect:
        marketlogService.count() == 5

        when:
        marketlogService.delete(marketlogId)
        sessionFactory.currentSession.flush()

        then:
        marketlogService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Marketlog marketlog = new Marketlog()
        marketlogService.save(marketlog)

        then:
        marketlog.id != null
    }
}
