/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.api;

import com.eureka.v1_0.kyc.information.exchange.api.KycInformationApiService;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.CreateEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.CreateEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.FindAccountEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.FindAccountEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.RemoveEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.RemoveEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.UpdateEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.UpdateEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.ValidateEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.ValidateEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.CreateMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.CreateMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindAccountMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindAccountMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindMsisdnInformationByUidRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindMsisdnInformationByUidResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.RemoveMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.RemoveMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.UpdateMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.UpdateMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.ValidateMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.ValidateMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.CreatePersonalInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.CreatePersonalInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByAccountNameRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByAccountNameResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByEmailRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByEmailResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByUidRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByUidResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.UpdatePersonalInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.UpdatePersonalInformationResponse;
import com.wit.ng.aurora.commons.jaxb.marshalling.io.JaxbHandler;
import com.wit.ng.christians.ng.ilogger.api.WitLoggerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ceowit
 */
@Controller
@RequestMapping(value = "/kyc")
public class KycInformationApiController {

    @Autowired
    @Qualifier(value = "witLoggerServiceImpl")
    WitLoggerService witLoggerService;

    @Autowired
    @Qualifier(value = "kycInformationApiServiceImpl")
    KycInformationApiService kycInformationApiService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/createpersonalinformation")
    public CreatePersonalInformationResponse createPersonalInformation(@RequestBody CreatePersonalInformationRequest createPersonalInformationRequest, HttpServletRequest request, HttpServletResponse response) {
        if (createPersonalInformationRequest != null) {
            try {
                witLoggerService.debug(JaxbHandler.toXml(createPersonalInformationRequest));
                CreatePersonalInformationResponse createPersonalInformationResponse = this.kycInformationApiService.createPersonalInformation(createPersonalInformationRequest);
                if (createPersonalInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(createPersonalInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return createPersonalInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/findpersonalinformationbyaccountname")
    public FindPersonalInformationByAccountNameResponse findPersonalInformationByAccountName(@RequestBody FindPersonalInformationByAccountNameRequest findPersonalInformationByAccountNameRequest, HttpServletResponse response, HttpServletRequest request) {
        if (findPersonalInformationByAccountNameRequest != null) {
            try {
                witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByAccountNameRequest));
                FindPersonalInformationByAccountNameResponse findPersonalInformationByAccountNameResponse = this.kycInformationApiService.findPersonalInformationByAccountName(findPersonalInformationByAccountNameRequest);
                if (findPersonalInformationByAccountNameResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByAccountNameResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return findPersonalInformationByAccountNameResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/findpersonalinformationbyemail")
    public FindPersonalInformationByEmailResponse findPersonalInformationByEmail(@RequestBody FindPersonalInformationByEmailRequest findPersonalInformationByEmailRequest, HttpServletRequest request, HttpServletResponse response) {
        if (findPersonalInformationByEmailRequest != null) {
            try {
                witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByEmailRequest));
                FindPersonalInformationByEmailResponse findPersonalInformationByEmailResponse = this.kycInformationApiService.findPersonalInformationByEmail(findPersonalInformationByEmailRequest);
                if (findPersonalInformationByEmailResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByEmailResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return findPersonalInformationByEmailResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/findpersonalinformationbyuid")
    public FindPersonalInformationByUidResponse findPersonalInformationByUid(@RequestBody FindPersonalInformationByUidRequest findPersonalInformationByUidRequest, HttpServletRequest request, HttpServletResponse response) {
        if (findPersonalInformationByUidRequest != null) {
            try {
                witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByUidRequest));
                FindPersonalInformationByUidResponse findPersonalInformationByUidResponse = this.kycInformationApiService.findPersonalInformationByUid(findPersonalInformationByUidRequest);
                if (findPersonalInformationByUidResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByUidResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return findPersonalInformationByUidResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/updatepersonalinformation")
    public UpdatePersonalInformationResponse updatePersonalInformation(@RequestBody UpdatePersonalInformationRequest updatePersonalInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (updatePersonalInformationRequest != null) {
            try {
                witLoggerService.debug(JaxbHandler.toXml(updatePersonalInformationRequest));
                UpdatePersonalInformationResponse updatePersonalInformationResponse = this.kycInformationApiService.updatePersonalInformation(updatePersonalInformationRequest);
                if (updatePersonalInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(updatePersonalInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return updatePersonalInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/createmsisdninformation")
    public CreateMsisdnInformationResponse createMsisdnInformation(@RequestBody CreateMsisdnInformationRequest createMsisdnInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (createMsisdnInformationRequest != null) {
            try {
                witLoggerService.debug(JaxbHandler.toXml(createMsisdnInformationRequest));
                CreateMsisdnInformationResponse createMsisdnInformationResponse = this.kycInformationApiService.createMsisdnInformation(createMsisdnInformationRequest);
                if (createMsisdnInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(createMsisdnInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return createMsisdnInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/findaccountmsisdninformation")
    public FindAccountMsisdnInformationResponse findAccountMsisdnInformation(@RequestBody FindAccountMsisdnInformationRequest findAccountMsisdnInformationRequest, HttpServletRequest request, HttpServletResponse response) {
        if (findAccountMsisdnInformationRequest != null) {
            try {
                FindAccountMsisdnInformationResponse findAccountMsisdnInformationResponse = this.kycInformationApiService.findAccountMsisdnInformation(findAccountMsisdnInformationRequest);
                if (findAccountMsisdnInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(findAccountMsisdnInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return findAccountMsisdnInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/findmsisdninformationbyuid")
    public FindMsisdnInformationByUidResponse findMsisdnInformationByUid(@RequestBody FindMsisdnInformationByUidRequest findMsisdnInformationByUidRequest, HttpServletResponse response, HttpServletRequest request) {
        if (findMsisdnInformationByUidRequest != null) {
            try {
                FindMsisdnInformationByUidResponse findMsisdnInformationByUidResponse = this.kycInformationApiService.findMsisdnInformationByUid(findMsisdnInformationByUidRequest);
                if (findMsisdnInformationByUidResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(findMsisdnInformationByUidResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return findMsisdnInformationByUidResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/removemsisdninformation")
    public RemoveMsisdnInformationResponse removeMsisdnInformation(@RequestBody RemoveMsisdnInformationRequest removeMsisdnInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (removeMsisdnInformationRequest != null) {
            try {
                RemoveMsisdnInformationResponse removeMsisdnInformationResponse = this.kycInformationApiService.removeMsisdnInformation(removeMsisdnInformationRequest);
                if (removeMsisdnInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(removeMsisdnInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return removeMsisdnInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/updatemsisdninformation")
    public UpdateMsisdnInformationResponse updateMsisdnInformation(@RequestBody UpdateMsisdnInformationRequest updateMsisdnInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (updateMsisdnInformationRequest != null) {
            try {
                UpdateMsisdnInformationResponse updateMsisdnInformationResponse = this.kycInformationApiService.updateMsisdnInformation(updateMsisdnInformationRequest);
                if (updateMsisdnInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(updateMsisdnInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return updateMsisdnInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/validatemsisdninformation")
    public ValidateMsisdnInformationResponse validateMsisdnInformation(@RequestBody ValidateMsisdnInformationRequest validateMsisdnInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (validateMsisdnInformationRequest != null) {
            try {
                ValidateMsisdnInformationResponse validateMsisdnInformationResponse = this.kycInformationApiService.validateMsisdnInformation(validateMsisdnInformationRequest);
                if (validateMsisdnInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(validateMsisdnInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return validateMsisdnInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/createemailinformation")
    public CreateEmailInformationResponse createEmailInformation(@RequestBody CreateEmailInformationRequest createEmailInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (createEmailInformationRequest != null) {
            try {
                CreateEmailInformationResponse createEmailInformationResponse = this.kycInformationApiService.createEmailInformation(createEmailInformationRequest);
                if (createEmailInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(createEmailInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return createEmailInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/findaccountemailinformation")
    public FindAccountEmailInformationResponse findAccountEmailInformation(@RequestBody FindAccountEmailInformationRequest findAccountEmailInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (findAccountEmailInformationRequest != null) {
            try {
                FindAccountEmailInformationResponse findAccountEmailInformationResponse = this.kycInformationApiService.findAccountEmailInformation(findAccountEmailInformationRequest);
                if (findAccountEmailInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(findAccountEmailInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return findAccountEmailInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/removeemailinformation")
    public RemoveEmailInformationResponse removeEmailInformation(@RequestBody RemoveEmailInformationRequest removeEmailInformationRequest, HttpServletResponse response, HttpServletRequest request) {
        if (removeEmailInformationRequest != null) {
            try {
                RemoveEmailInformationResponse removeEmailInformationResponse = this.kycInformationApiService.removeEmailInformation(removeEmailInformationRequest);
                if (removeEmailInformationResponse != null) {
                    witLoggerService.debug(JaxbHandler.toXml(removeEmailInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return removeEmailInformationResponse;
                } else {
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/updateemailinformation")
    public UpdateEmailInformationResponse updateEmailInformation(@RequestBody UpdateEmailInformationRequest updateEmailInformationRequest, HttpServletResponse response, HttpServletRequest request){
        if(updateEmailInformationRequest != null){
            try {
                UpdateEmailInformationResponse updateEmailInformationResponse = this.kycInformationApiService.updateEmailInformation(updateEmailInformationRequest);
                if(updateEmailInformationResponse != null){
                    witLoggerService.debug(JaxbHandler.toXml(updateEmailInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return updateEmailInformationResponse;                    
                }else{
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;        
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE, value = "/validateemailinformation")    
    public ValidateEmailInformationResponse validateEmailInformation(@RequestBody ValidateEmailInformationRequest validateEmailInformationRequest, HttpServletResponse response, HttpServletRequest request){
        if(validateEmailInformationRequest != null){
            try {
                ValidateEmailInformationResponse validateEmailInformationResponse = this.kycInformationApiService.validateEmailInformation(validateEmailInformationRequest);
                if(validateEmailInformationResponse != null){
                    witLoggerService.debug(JaxbHandler.toXml(validateEmailInformationResponse));
                    response.setStatus(HttpServletResponse.SC_OK);
                    return validateEmailInformationResponse;                                        
                }else{
                    response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                }
            } catch (Exception ex) {
                witLoggerService.warn(ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;                
    }
}
