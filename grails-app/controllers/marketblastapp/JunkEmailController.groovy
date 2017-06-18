package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class JunkEmailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    	@Secured(['ROLE_USER'])
def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond JunkEmail.list(params), model:[junkEmailCount: JunkEmail.count()]
    }

	@Secured(['ROLE_USER'])
    def show(JunkEmail junkEmail) {
        respond junkEmail
    }

	@Secured(['ROLE_USER'])
    def create() {
        respond new JunkEmail(params)
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def save(JunkEmail junkEmail) {
        if (junkEmail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (junkEmail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond junkEmail.errors, view:'create'
            return
        }

        junkEmail.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'junkEmail.label', default: 'JunkEmail'), junkEmail.id])
                redirect junkEmail
            }
            '*' { respond junkEmail, [status: CREATED] }
        }
    }

	@Secured(['ROLE_USER'])
    def edit(JunkEmail junkEmail) {
        respond junkEmail
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(JunkEmail junkEmail) {
        if (junkEmail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (junkEmail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond junkEmail.errors, view:'edit'
            return
        }

        junkEmail.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'junkEmail.label', default: 'JunkEmail'), junkEmail.id])
                redirect junkEmail
            }
            '*'{ respond junkEmail, [status: OK] }
        }
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(JunkEmail junkEmail) {

        if (junkEmail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        junkEmail.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'junkEmail.label', default: 'JunkEmail'), junkEmail.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'junkEmail.label', default: 'JunkEmail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
