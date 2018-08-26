package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MoonmaterialController {

    MoonmaterialService moonmaterialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def import_form() {
    }

        def import_submit() {
        int updated = moonmaterialService.submitMoonProbeAndAnalysis(params.text_data)

        request.withFormat {
            form multipartForm {
                flash.message = message( message: "Successfully imported ${updated} rows of moon materials")
                redirect action:"import_form", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond moonmaterialService.list(params), model:[moonmaterialCount: moonmaterialService.count()]
    }

    def show(Long id) {
        respond moonmaterialService.get(id)
    }

    def create() {
        respond new Moonmaterial(params)
    }

    def save(Moonmaterial moonmaterial) {
        if (moonmaterial == null) {
            notFound()
            return
        }

        try {
            moonmaterialService.save(moonmaterial)
        } catch (ValidationException e) {
            respond moonmaterial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'moonmaterial.label', default: 'Moonmaterial'), moonmaterial.id])
                redirect moonmaterial
            }
            '*' { respond moonmaterial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond moonmaterialService.get(id)
    }

    def update(Moonmaterial moonmaterial) {
        if (moonmaterial == null) {
            notFound()
            return
        }

        try {
            moonmaterialService.save(moonmaterial)
        } catch (ValidationException e) {
            respond moonmaterial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'moonmaterial.label', default: 'Moonmaterial'), moonmaterial.id])
                redirect moonmaterial
            }
            '*'{ respond moonmaterial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        moonmaterialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'moonmaterial.label', default: 'Moonmaterial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'moonmaterial.label', default: 'Moonmaterial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
