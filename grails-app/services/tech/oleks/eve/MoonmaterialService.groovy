package tech.oleks.eve

import grails.gorm.services.Service
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

@Service(Moonmaterial)
abstract class MoonmaterialService {

    abstract Moonmaterial get(Serializable id)

    abstract List<Moonmaterial> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Moonmaterial save(Moonmaterial moonmaterial)

    @Autowired
    SessionFactory sessionFactory

    def submitMoonProbeAndAnalysis(String text) {
        def lines = text.readLines()
        int rows;
        lines.each { String line ->
            def tokens = line.split(/\t+/)
            // Line started with tab, this is a data row
            if (!tokens[0]) {
                String oreName = tokens[1]
                Float quantity = Float.parseFloat(tokens[2])
                Long oreTypeId = Long.parseLong(tokens[3])
                Long solarSystemId = Long.parseLong(tokens[4])
                Long planetId = Long.parseLong(tokens[5])
                Long moonId = Long.parseLong(tokens[6])

                Invtype ore = Invtype.get(oreTypeId)
                Invitem moon = Invitem.get(moonId)
                if (!moon || !ore) {
                    throw new RuntimeException("Could not resolve moon ${moon} and ore ${ore}")
                }

                Moonmaterial mat = Moonmaterial.findByMoonAndOretype(moon, ore)
                if (!mat) {
                    mat = new Moonmaterial()
                }
                mat.quantity = quantity
                mat.oretype = ore
                mat.solarsystem = Mapsolarsystem.get(solarSystemId)
                mat.planetid = planetId
                mat.moon = moon
                if (oreName != mat.oretype.typename) {
                    throw new RuntimeException("oreName ${oreName} <> oreType ${mat.oretype.typename}")
                }
                if (!mat.save(true)) {
                    throw new RuntimeException("Line did not pass validation: " + line)
                }

                ++rows
            }
        }
        if (rows > 0) {
            sessionFactory.currentSession.flush()
        }
        return rows
    }

}