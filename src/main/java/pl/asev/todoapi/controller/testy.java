//package pl.asev.todoapi.controller;
//
//import org.springframework.http.MediaType;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//public class testy {
//    @RequestMapping(value = "/{email}/authenticate", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public @ResponseBody
//    Representation authenticate(@PathVariable("email") String anEmailAddress, MultiValueMap paramMap) throws Exception {
//        if(paramMap == null && paramMap.get("password") == null) {
//            throw new IllegalArgumentException("Password not provided");
//        }
//        return null;
//    }
//
//}
