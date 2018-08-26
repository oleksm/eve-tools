package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InvtypematerialController {

    InvtypematerialService invtypematerialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond invtypematerialService.list(params), model:[invtypematerialCount: invtypematerialService.count()]
    }

    def show(Long id) {
        respond invtypematerialService.get(id)
    }

    def create() {
        respond new Invtypematerial(params)
    }

    def save(Invtypematerial invtypematerial) {
        if (invtypematerial == null) {
            notFound()
            return
        }

        try {
            invtypematerialService.save(invtypematerial)
        } catch (ValidationException e) {
            respond invtypematerial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'invtypematerial.label', default: 'Invtypematerial'), invtypematerial.id])
                redirect invtypematerial
            }
            '*' { respond invtypematerial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond invtypematerialService.get(id)
    }

    def update(Invtypematerial invtypematerial) {
        if (invtypematerial == null) {
            notFound()
            return
        }

        try {
            invtypematerialService.save(invtypematerial)
        } catch (ValidationException e) {
            respond invtypematerial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'invtypematerial.label', default: 'Invtypematerial'), invtypematerial.id])
                redirect invtypematerial
            }
            '*'{ respond invtypematerial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        invtypematerialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'invtypematerial.label', default: 'Invtypematerial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'invtypematerial.label', default: 'Invtypematerial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
