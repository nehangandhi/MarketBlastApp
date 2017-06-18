package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WebsiteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Website.list(params), model:[websiteCount: Website.count()]
    }

    @Secured(['ROLE_USER'])
    def show(Website website) {
        respond website
    }

    @Secured(['ROLE_USER'])
    def create() {
        respond new Website(params)
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def save(Website website) {
        if (website == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (website.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond website.errors, view:'create'
            return
        }

        website.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'website.label', default: 'Website'), website.id])
                redirect website
            }
            '*' { respond website, [status: CREATED] }
        }
    }

    @Secured(['ROLE_USER'])
    def edit(Website website) {
        respond website
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def update(Website website) {
        if (website == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (website.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond website.errors, view:'edit'
            return
        }

        website.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'website.label', default: 'Website'), website.id])
                redirect website
            }
            '*'{ respond website, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def delete(Website website) {

        if (website == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        website.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'website.label', default: 'Website'), website.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'website.label', default: 'Website'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
