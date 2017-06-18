package marketblastapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		"/login/$action?"(controller: "login")
		"/logout/$action?"(controller: "logout")
		
       "/"(view:"/index")
       // "/"(controller:"user", action:"login")
       
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
