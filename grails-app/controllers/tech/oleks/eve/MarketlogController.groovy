package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MarketlogController {

    MarketlogService marketlogService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond marketlogService.list(params), model:[marketlogCount: marketlogService.count()]
    }

    def import_log() {
        int updated = marketlogService.createFromRawData(params.market_log_content)
        log.info("Imported ${updated} lines of market log data")
        render(status: 200, text: "Imported ${updated} lines of market log data")
    }

    def show(Long id) {
        respond marketlogService.get(id)
    }

    def create() {
        respond new Marketlog(params)
    }

    def save(Marketlog marketlog) {
        if (marketlog == null) {
            notFound()
            return
        }

        try {
            marketlogService.save(marketlog)
        } catch (ValidationException e) {
            respond marketlog.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'marketlog.label', default: 'Marketlog'), marketlog.id])
                redirect marketlog
            }
            '*' { respond marketlog, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond marketlogService.get(id)
    }

    def update(Marketlog marketlog) {
        if (marketlog == null) {
            notFound()
            return
        }

        try {
            marketlogService.save(marketlog)
        } catch (ValidationException e) {
            respond marketlog.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'marketlog.label', default: 'Marketlog'), marketlog.id])
                redirect marketlog
            }
            '*'{ respond marketlog, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        marketlogService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'marketlog.label', default: 'Marketlog'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'marketlog.label', default: 'Marketlog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
