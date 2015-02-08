//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.05 at 05:33:15 PM PHT 
//


package com.customer.rti.rim2016.v1_2.fps.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for FullPaymentSubmission_ContactDetailsStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FullPaymentSubmission_ContactDetailsStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Ttl" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="4"/>
 *                         &lt;pattern value="[A-Za-z][A-Za-z'\-]*"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Fore" maxOccurs="2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="35"/>
 *                         &lt;pattern value="[A-Za-z][A-Za-z'\-]*"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Sur">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="35"/>
 *                         &lt;pattern value="[A-Za-z0-9 ,\.\(\)/&amp;\-']+"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Email" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1>FullPaymentSubmission_EmailType">
 *                 &lt;attribute name="Type" type="{http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1}FullPaymentSubmission_WorkHomeType" />
 *                 &lt;attribute name="Preferred" type="{http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1}FullPaymentSubmission_YesNoType" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Telephone" type="{http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1}FullPaymentSubmission_TelephoneStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1}FullPaymentSubmission_TelephoneStructure" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullPaymentSubmission_ContactDetailsStructure", propOrder = {
    "name",
    "email",
    "telephone",
    "fax"
})
public class FullPaymentSubmissionContactDetailsStructure {

    @XmlElement(name = "Name")
    protected FullPaymentSubmissionContactDetailsStructure.Name name;
    @XmlElement(name = "Email")
    protected List<FullPaymentSubmissionContactDetailsStructure.Email> email;
    @XmlElement(name = "Telephone")
    protected List<FullPaymentSubmissionTelephoneStructure> telephone;
    @XmlElement(name = "Fax")
    protected List<FullPaymentSubmissionTelephoneStructure> fax;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link FullPaymentSubmissionContactDetailsStructure.Name }
     *     
     */
    public FullPaymentSubmissionContactDetailsStructure.Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullPaymentSubmissionContactDetailsStructure.Name }
     *     
     */
    public void setName(FullPaymentSubmissionContactDetailsStructure.Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the email property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FullPaymentSubmissionContactDetailsStructure.Email }
     * 
     * 
     */
    public List<FullPaymentSubmissionContactDetailsStructure.Email> getEmail() {
        if (email == null) {
            email = new ArrayList<FullPaymentSubmissionContactDetailsStructure.Email>();
        }
        return this.email;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telephone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelephone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FullPaymentSubmissionTelephoneStructure }
     * 
     * 
     */
    public List<FullPaymentSubmissionTelephoneStructure> getTelephone() {
        if (telephone == null) {
            telephone = new ArrayList<FullPaymentSubmissionTelephoneStructure>();
        }
        return this.telephone;
    }

    /**
     * Gets the value of the fax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FullPaymentSubmissionTelephoneStructure }
     * 
     * 
     */
    public List<FullPaymentSubmissionTelephoneStructure> getFax() {
        if (fax == null) {
            fax = new ArrayList<FullPaymentSubmissionTelephoneStructure>();
        }
        return this.fax;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1>FullPaymentSubmission_EmailType">
     *       &lt;attribute name="Type" type="{http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1}FullPaymentSubmission_WorkHomeType" />
     *       &lt;attribute name="Preferred" type="{http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/15-16/1}FullPaymentSubmission_YesNoType" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Email {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "Type")
        protected FullPaymentSubmissionWorkHomeType type;
        @XmlAttribute(name = "Preferred")
        protected FullPaymentSubmissionYesNoType preferred;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link FullPaymentSubmissionWorkHomeType }
         *     
         */
        public FullPaymentSubmissionWorkHomeType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link FullPaymentSubmissionWorkHomeType }
         *     
         */
        public void setType(FullPaymentSubmissionWorkHomeType value) {
            this.type = value;
        }

        /**
         * Gets the value of the preferred property.
         * 
         * @return
         *     possible object is
         *     {@link FullPaymentSubmissionYesNoType }
         *     
         */
        public FullPaymentSubmissionYesNoType getPreferred() {
            return preferred;
        }

        /**
         * Sets the value of the preferred property.
         * 
         * @param value
         *     allowed object is
         *     {@link FullPaymentSubmissionYesNoType }
         *     
         */
        public void setPreferred(FullPaymentSubmissionYesNoType value) {
            this.preferred = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Ttl" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="4"/>
     *               &lt;pattern value="[A-Za-z][A-Za-z'\-]*"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Fore" maxOccurs="2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="35"/>
     *               &lt;pattern value="[A-Za-z][A-Za-z'\-]*"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Sur">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="35"/>
     *               &lt;pattern value="[A-Za-z0-9 ,\.\(\)/&amp;\-']+"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ttl",
        "fore",
        "sur"
    })
    public static class Name {

        @XmlElement(name = "Ttl")
        protected String ttl;
        @XmlElement(name = "Fore", required = true)
        protected List<String> fore;
        @XmlElement(name = "Sur", required = true)
        protected String sur;

        /**
         * Gets the value of the ttl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTtl() {
            return ttl;
        }

        /**
         * Sets the value of the ttl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTtl(String value) {
            this.ttl = value;
        }

        /**
         * Gets the value of the fore property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fore property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFore().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFore() {
            if (fore == null) {
                fore = new ArrayList<String>();
            }
            return this.fore;
        }

        /**
         * Gets the value of the sur property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSur() {
            return sur;
        }

        /**
         * Sets the value of the sur property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSur(String value) {
            this.sur = value;
        }

    }

}
