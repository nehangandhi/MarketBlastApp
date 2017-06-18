package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmailCommunicationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    	@Secured(['ROLE_USER'])
		def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EmailCommunication.list(params), model:[emailCommunicationCount: EmailCommunication.count()]
    }

    	@Secured(['ROLE_USER'])
		def show(EmailCommunication emailCommunication) {
        respond emailCommunication
    }

    	@Secured(['ROLE_USER'])
		def create() {
        respond new EmailCommunication(params)
    }

    @Transactional
    	@Secured(['ROLE_USER'])
		def save(EmailCommunication emailCommunication) {
        if (emailCommunication == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (emailCommunication.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond emailCommunication.errors, view:'create'
            return
        }

        emailCommunication.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emailCommunication.label', default: 'EmailCommunication'), emailCommunication.id])
                redirect emailCommunication
            }
            '*' { respond emailCommunication, [status: CREATED] }
        }
    }

    	@Secured(['ROLE_USER'])
		def edit(EmailCommunication emailCommunication) {
        respond emailCommunication
    }

    @Transactional
    	@Secured(['ROLE_USER'])
		def update(EmailCommunication emailCommunication) {
        if (emailCommunication == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (emailCommunication.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond emailCommunication.errors, view:'edit'
            return
        }

        emailCommunication.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emailCommunication.label', default: 'EmailCommunication'), emailCommunication.id])
                redirect emailCommunication
            }
            '*'{ respond emailCommunication, [status: OK] }
        }
    }

    @Transactional
    	@Secured(['ROLE_USER'])
		def delete(EmailCommunication emailCommunication) {

        if (emailCommunication == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        emailCommunication.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'emailCommunication.label', default: 'EmailCommunication'), emailCommunication.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emailCommunication.label', default: 'EmailCommunication'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
