package tech.oleks.eve

import grails.gorm.services.Service
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

@Service(Marketlog)
abstract class MarketlogService {

    abstract Marketlog get(Serializable id)

    abstract List<Marketlog> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Marketlog save(Marketlog marketlog)

    @Autowired
    SessionFactory sessionFactory

    def createFromRawData(String content) {
        def lines = content?.readLines()
        int rows;
        lines?.each { String line ->
            def tokens = line.split(/,/)
            // Not a header row
            if (!tokens[0].matches(/\w+/)) {
                // First check if station is NPC based. Human citadels are skipped as is for now
                Long stationId = Long.parseLong(tokens[10])
                if (!stationId ) {
                    throw new RuntimeException("Could not resolve stationId ${stationId}")
                }
                if (stationId <= Integer.MAX_VALUE && !Stastation.get(stationId)) {
                    throw new RuntimeException("Could not resolve station ${stationId}")
                }
                Long orderId = Long.parseLong(tokens[4])
                Invtype invtype = Invtype.get(Long.parseLong(tokens[2]))
                if (!orderId || !invtype ) {
                    throw new RuntimeException("Could not resolve orderId ${orderId} and type ${invtype}")
                }
                Marketlog logItem = Marketlog.findByOrderidAndInvtype(orderId, invtype)
                if (!logItem) {
                    logItem = new Marketlog()
                }
                logItem.lastupdated = new Date()
                logItem.price = Float.parseFloat(tokens[0])
                logItem.volremaining = Long.parseLong(tokens[1].replaceFirst(/\.0+/, ''))
                logItem.invtype = invtype
                logItem.range = Long.parseLong(tokens[3])
                logItem.orderid = orderId
                logItem.volentered = Long.parseLong(tokens[5])
                logItem.minvolume = Integer.parseInt(tokens[6])
                logItem.bid = Boolean.parseBoolean(tokens[7])
                logItem.issuedate = Date.parse("yyyy-MM-dd HH:mm:ss.SSS", tokens[8], TimeZone.getTimeZone("GMT"))
                logItem.duration = Integer.parseInt(tokens[9])
                logItem.stationid = stationId
                logItem.regionid = Long.parseLong(tokens[11])
                logItem.solarsystemid = Long.parseLong(tokens[12])
                logItem.jumps = Integer.parseInt(tokens[13])
                ++rows
                if (!logItem.save(true)) {
                    throw new RuntimeException("Market log line did not pass validation: " + line)
                }
            }
        }
        if (rows > 0) {
            sessionFactory.currentSession.flush()
        }
        return rows
    }
}
