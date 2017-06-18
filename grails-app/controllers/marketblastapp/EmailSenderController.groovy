package marketblastapp

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.MultipartFile

class EmailSenderController {

    @Secured(['ROLE_USER'])
    def index() { }
    
    @Secured(['ROLE_USER'])
    def send() {
    sendMail {
        to params.address
        subject params.subject
        //html params.body
        //html view: "/emailSender/template", model: [param1: "value1", param2: "value2"]
        //html g.render(template:'/emailSender/template', model:
    }
    
    /*@Secured(['ROLE_USER'])
    def send() {
    def multipartFile = request.getFile('attachment')

    sendMail {
        multipart true
        to params.address
        subject params.subject
        html params.body
        if(multipartFile && !multipartFile.empty) {
          File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + multipartFile.getOriginalFilename());
          multipartFile.transferTo(tmpFile);
          attach tmpFile
        }
     }*/
    
    flash.message = "Message sent at "+new Date()
    redirect action:"index"
}
}
