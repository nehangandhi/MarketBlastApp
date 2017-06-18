package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmailCampaignController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EmailCampaign.list(params), model:[emailCampaignCount: EmailCampaign.count()]
    }

    @Secured(['ROLE_USER'])
    def show(EmailCampaign emailCampaign) {
        respond emailCampaign
    }

    @Secured(['ROLE_USER'])
    def create() {
        respond new EmailCampaign(params)
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def save(EmailCampaign emailCampaign) {
        if (emailCampaign == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (emailCampaign.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond emailCampaign.errors, view:'create'
            return
        }

        emailCampaign.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emailCampaign.label', default: 'EmailCampaign'), emailCampaign.id])
                redirect emailCampaign
            }
            '*' { respond emailCampaign, [status: CREATED] }
        }
    }

    @Secured(['ROLE_USER'])
    def edit(EmailCampaign emailCampaign) {
        respond emailCampaign
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def update(EmailCampaign emailCampaign) {
        if (emailCampaign == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (emailCampaign.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond emailCampaign.errors, view:'edit'
            return
        }

        emailCampaign.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emailCampaign.label', default: 'EmailCampaign'), emailCampaign.id])
                redirect emailCampaign
            }
            '*'{ respond emailCampaign, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def delete(EmailCampaign emailCampaign) {

        if (emailCampaign == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        emailCampaign.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'emailCampaign.label', default: 'EmailCampaign'), emailCampaign.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emailCampaign.label', default: 'EmailCampaign'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
