package com.whitelist.taxpayers.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Entity
 */
@Validated
public class Entity {
	
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("nip")
	private String nip = null;

	/**
	 * Status podatnika VAT.
	 */
	public enum StatusVatEnum {
		CZYNNY("Czynny"),

		ZWOLNIONY("Zwolniony"),

		PODMIOT_NIEZAREJESTROWANY_DO_VAT("Podmiot niezarejestrowany do VAT");

		private String value;

		StatusVatEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusVatEnum fromValue(String text) {
			for (StatusVatEnum b : StatusVatEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("statusVat")
	private StatusVatEnum statusVat = null;

	@JsonProperty("regon")
	private String regon = null;

	@JsonProperty("pesel")
	private String pesel = null;

	@JsonProperty("krs")
	private String krs = null;

	@JsonProperty("residenceAddress")
	private String residenceAddress = null;

	@JsonProperty("workingAddress")
	private String workingAddress = null;

	@JsonProperty("representatives")
	@Valid
	private List<Person> representatives = null;

	@JsonProperty("authorizedClerks")
	@Valid
	private List<Person> authorizedClerks = null;

	@JsonProperty("partners")
	@Valid
	private List<EntityPerson> partners = null;

	@JsonProperty("registrationLegalDate")
	private String registrationLegalDate = null;

	@JsonProperty("registrationDenialDate")
	private String registrationDenialDate = null;

	@JsonProperty("registrationDenialBasis")
	private String registrationDenialBasis = null;

	@JsonProperty("restorationDate")
	private String restorationDate = null;

	@JsonProperty("restorationBasis")
	private String restorationBasis = null;

	@JsonProperty("removalDate")
	private String removalDate = null;

	@JsonProperty("removalBasis")
	private String removalBasis = null;

	@JsonProperty("accountNumbers")
	@Valid
	private List<String> accountNumbers = null;

	@JsonProperty("hasVirtualAccounts")
	private Boolean hasVirtualAccounts = null;

	public Entity name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Firma (nazwa) lub imię i nazwisko
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "ABC Jan Nowak", required = true, value = "Firma (nazwa) lub imię i nazwisko ")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Entity nip(String nip) {
		this.nip = nip;
		return this;
	}

	/**
	 * Get nip
	 * 
	 * @return nip
	 **/
	@ApiModelProperty(example = "1111111111", value = "")

	@Size(min = 10, max = 10)
	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public Entity statusVat(StatusVatEnum statusVat) {
		this.statusVat = statusVat;
		return this;
	}

	/**
	 * Status podatnika VAT.
	 * 
	 * @return statusVat
	 **/
	@ApiModelProperty(example = "Zwolniony", value = "Status podatnika VAT. ")

	public StatusVatEnum getStatusVat() {
		return statusVat;
	}

	public void setStatusVat(StatusVatEnum statusVat) {
		this.statusVat = statusVat;
	}

	public Entity regon(String regon) {
		this.regon = regon;
		return this;
	}

	/**
	 * Numer identyfikacyjny REGON
	 * 
	 * @return regon
	 **/
	@ApiModelProperty(value = "Numer identyfikacyjny REGON ")

	@Pattern(regexp = "^\\d{9}$|^\\d{14}$")
	public String getRegon() {
		return regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public Entity pesel(String pesel) {
		this.pesel = pesel;
		return this;
	}

	/**
	 * Get pesel
	 * 
	 * @return pesel
	 **/
	@ApiModelProperty(value = "")

	@Size(min = 11, max = 11)
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Entity krs(String krs) {
		this.krs = krs;
		return this;
	}

	/**
	 * numer KRS jeżeli został nadany
	 * 
	 * @return krs
	 **/
	@ApiModelProperty(example = "0000636771", value = "numer KRS jeżeli został nadany ")

	@Size(min = 10, max = 10)
	public String getKrs() {
		return krs;
	}

	public void setKrs(String krs) {
		this.krs = krs;
	}

	public Entity residenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
		return this;
	}

	/**
	 * Adres siedziby
	 * 
	 * @return residenceAddress
	 **/
	@ApiModelProperty(example = "ul/ Chmielna 85/87 00-805 Warszawa", value = "Adres siedziby ")

	@Size(max = 200)
	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public Entity workingAddress(String workingAddress) {
		this.workingAddress = workingAddress;
		return this;
	}

	/**
	 * Adres stałego miejsca prowadzenia działalności lub adres miejsca zamieszkania
	 * w przypadku braku adresu stałego miejsca prowadzenia działalności
	 * 
	 * @return workingAddress
	 **/
	@ApiModelProperty(example = "ul/ Prosta 49 00-838 Warszawa", value = "Adres stałego miejsca prowadzenia działalności lub adres miejsca zamieszkania w przypadku braku adresu stałego miejsca prowadzenia działalności ")

	@Size(max = 200)
	public String getWorkingAddress() {
		return workingAddress;
	}

	public void setWorkingAddress(String workingAddress) {
		this.workingAddress = workingAddress;
	}

	public Entity representatives(List<Person> representatives) {
		this.representatives = representatives;
		return this;
	}

	public Entity addRepresentativesItem(Person representativesItem) {
		if (this.representatives == null) {
			this.representatives = new ArrayList<Person>();
		}
		this.representatives.add(representativesItem);
		return this;
	}

	/**
	 * Imiona i nazwiska osób wchodzących w skład organu uprawnionego do
	 * reprezentowania podmiotu oraz ich numery NIP i/lub PESEL
	 * 
	 * @return representatives
	 **/
	@ApiModelProperty(value = "Imiona i nazwiska osób wchodzących w skład organu uprawnionego do reprezentowania podmiotu oraz ich numery NIP i/lub PESEL ")

	@Valid

	public List<Person> getRepresentatives() {
		return representatives;
	}

	public void setRepresentatives(List<Person> representatives) {
		this.representatives = representatives;
	}

	public Entity authorizedClerks(List<Person> authorizedClerks) {
		this.authorizedClerks = authorizedClerks;
		return this;
	}

	public Entity addAuthorizedClerksItem(Person authorizedClerksItem) {
		if (this.authorizedClerks == null) {
			this.authorizedClerks = new ArrayList<Person>();
		}
		this.authorizedClerks.add(authorizedClerksItem);
		return this;
	}

	/**
	 * Imiona i nazwiska prokurentów oraz ich numery NIP i/lub PESEL
	 * 
	 * @return authorizedClerks
	 **/
	@ApiModelProperty(value = "Imiona i nazwiska prokurentów oraz ich numery NIP i/lub PESEL ")

	@Valid

	public List<Person> getAuthorizedClerks() {
		return authorizedClerks;
	}

	public void setAuthorizedClerks(List<Person> authorizedClerks) {
		this.authorizedClerks = authorizedClerks;
	}

	public Entity partners(List<EntityPerson> partners) {
		this.partners = partners;
		return this;
	}

	public Entity addPartnersItem(EntityPerson partnersItem) {
		if (this.partners == null) {
			this.partners = new ArrayList<EntityPerson>();
		}
		this.partners.add(partnersItem);
		return this;
	}

	/**
	 * Imiona i nazwiska lub firmę (nazwa) wspólnika oraz jego numeryNIP i/lub PESEL
	 * 
	 * @return partners
	 **/
	@ApiModelProperty(value = "Imiona i nazwiska lub firmę (nazwa) wspólnika oraz jego numeryNIP i/lub PESEL ")

	@Valid

	public List<EntityPerson> getPartners() {
		return partners;
	}

	public void setPartners(List<EntityPerson> partners) {
		this.partners = partners;
	}

	public Entity registrationLegalDate(String registrationLegalDate) {
		this.registrationLegalDate = registrationLegalDate;
		return this;
	}

	/**
	 * Data rejestracji jako podatnika VAT
	 * 
	 * @return registrationLegalDate
	 **/
	@ApiModelProperty(value = "Data rejestracji jako podatnika VAT ")

	@Valid

	public String getRegistrationLegalDate() {
		return registrationLegalDate;
	}

	public void setRegistrationLegalDate(String registrationLegalDate) {
		this.registrationLegalDate = registrationLegalDate;
	}

	public Entity registrationDenialDate(String registrationDenialDate) {
		this.registrationDenialDate = registrationDenialDate;
		return this;
	}

	/**
	 * Data odmowy rejestracji jako podatnika VAT
	 * 
	 * @return registrationDenialDate
	 **/
	@ApiModelProperty(value = "Data odmowy rejestracji jako podatnika VAT ")

	@Valid

	public String getRegistrationDenialDate() {
		return registrationDenialDate;
	}

	public void setRegistrationDenialDate(String registrationDenialDate) {
		this.registrationDenialDate = registrationDenialDate;
	}

	public Entity registrationDenialBasis(String registrationDenialBasis) {
		this.registrationDenialBasis = registrationDenialBasis;
		return this;
	}

	/**
	 * Podstawa prawna odmowy rejestracji
	 * 
	 * @return registrationDenialBasis
	 **/
	@ApiModelProperty(example = "Ustawa o podatku od towarów i usług art. 96", value = "Podstawa prawna odmowy rejestracji ")

	@Size(max = 200)
	public String getRegistrationDenialBasis() {
		return registrationDenialBasis;
	}

	public void setRegistrationDenialBasis(String registrationDenialBasis) {
		this.registrationDenialBasis = registrationDenialBasis;
	}

	public Entity restorationDate(String restorationDate) {
		this.restorationDate = restorationDate;
		return this;
	}

	/**
	 * Data przywrócenia jako podatnika VAT
	 * 
	 * @return restorationDate
	 **/
	@ApiModelProperty(value = "Data przywrócenia jako podatnika VAT ")

	@Valid

	public String getRestorationDate() {
		return restorationDate;
	}

	public void setRestorationDate(String restorationDate) {
		this.restorationDate = restorationDate;
	}

	public Entity restorationBasis(String restorationBasis) {
		this.restorationBasis = restorationBasis;
		return this;
	}

	/**
	 * Podstawa prawna przywrócenia jako podatnika VAT
	 * 
	 * @return restorationBasis
	 **/
	@ApiModelProperty(example = "Ustawa o podatku od towarów i usług art. 96", value = "Podstawa prawna przywrócenia jako podatnika VAT ")

	@Size(max = 200)
	public String getRestorationBasis() {
		return restorationBasis;
	}

	public void setRestorationBasis(String restorationBasis) {
		this.restorationBasis = restorationBasis;
	}

	public Entity removalDate(String removalDate) {
		this.removalDate = removalDate;
		return this;
	}

	/**
	 * Data wykreślenia odmowy rejestracji jako podatnika VAT
	 * 
	 * @return removalDate
	 **/
	@ApiModelProperty(value = "Data wykreślenia odmowy rejestracji jako podatnika VAT ")

	@Valid

	public String getRemovalDate() {
		return removalDate;
	}

	public void setRemovalDate(String removalDate) {
		this.removalDate = removalDate;
	}

	public Entity removalBasis(String removalBasis) {
		this.removalBasis = removalBasis;
		return this;
	}

	/**
	 * Podstawa prawna wykreślenia odmowy rejestracji jako podatnika VAT
	 * 
	 * @return removalBasis
	 **/
	@ApiModelProperty(example = "Ustawa o podatku od towarów i usług Art. 97", value = "Podstawa prawna wykreślenia odmowy rejestracji jako podatnika VAT ")

	@Size(max = 200)
	public String getRemovalBasis() {
		return removalBasis;
	}

	public void setRemovalBasis(String removalBasis) {
		this.removalBasis = removalBasis;
	}

	public Entity accountNumbers(List<String> accountNumbers) {
		this.accountNumbers = accountNumbers;
		return this;
	}

	public Entity addAccountNumbersItem(String accountNumbersItem) {
		if (this.accountNumbers == null) {
			this.accountNumbers = new ArrayList<String>();
		}
		this.accountNumbers.add(accountNumbersItem);
		return this;
	}

	/**
	 * Get accountNumbers
	 * 
	 * @return accountNumbers
	 **/
	@ApiModelProperty(value = "")

	public List<String> getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(List<String> accountNumbers) {
		this.accountNumbers = accountNumbers;
	}

	public Entity hasVirtualAccounts(Boolean hasVirtualAccounts) {
		this.hasVirtualAccounts = hasVirtualAccounts;
		return this;
	}

	/**
	 * Podmiot posiada maski kont wirtualnych
	 * 
	 * @return hasVirtualAccounts
	 **/
	@ApiModelProperty(value = "Podmiot posiada maski kont wirtualnych ")

	public Boolean isHasVirtualAccounts() {
		return hasVirtualAccounts;
	}

	public void setHasVirtualAccounts(Boolean hasVirtualAccounts) {
		this.hasVirtualAccounts = hasVirtualAccounts;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Entity entity = (Entity) o;
		return Objects.equals(this.name, entity.name) && Objects.equals(this.nip, entity.nip)
				&& Objects.equals(this.statusVat, entity.statusVat) && Objects.equals(this.regon, entity.regon)
				&& Objects.equals(this.pesel, entity.pesel) && Objects.equals(this.krs, entity.krs)
				&& Objects.equals(this.residenceAddress, entity.residenceAddress)
				&& Objects.equals(this.workingAddress, entity.workingAddress)
				&& Objects.equals(this.representatives, entity.representatives)
				&& Objects.equals(this.authorizedClerks, entity.authorizedClerks)
				&& Objects.equals(this.partners, entity.partners)
				&& Objects.equals(this.registrationLegalDate, entity.registrationLegalDate)
				&& Objects.equals(this.registrationDenialDate, entity.registrationDenialDate)
				&& Objects.equals(this.registrationDenialBasis, entity.registrationDenialBasis)
				&& Objects.equals(this.restorationDate, entity.restorationDate)
				&& Objects.equals(this.restorationBasis, entity.restorationBasis)
				&& Objects.equals(this.removalDate, entity.removalDate)
				&& Objects.equals(this.removalBasis, entity.removalBasis)
				&& Objects.equals(this.accountNumbers, entity.accountNumbers)
				&& Objects.equals(this.hasVirtualAccounts, entity.hasVirtualAccounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, nip, statusVat, regon, pesel, krs, residenceAddress, workingAddress, representatives,
				authorizedClerks, partners, registrationLegalDate, registrationDenialDate, registrationDenialBasis,
				restorationDate, restorationBasis, removalDate, removalBasis, accountNumbers, hasVirtualAccounts);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Entity {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    nip: ").append(toIndentedString(nip)).append("\n");
		sb.append("    statusVat: ").append(toIndentedString(statusVat)).append("\n");
		sb.append("    regon: ").append(toIndentedString(regon)).append("\n");
		sb.append("    pesel: ").append(toIndentedString(pesel)).append("\n");
		sb.append("    krs: ").append(toIndentedString(krs)).append("\n");
		sb.append("    residenceAddress: ").append(toIndentedString(residenceAddress)).append("\n");
		sb.append("    workingAddress: ").append(toIndentedString(workingAddress)).append("\n");
		sb.append("    representatives: ").append(toIndentedString(representatives)).append("\n");
		sb.append("    authorizedClerks: ").append(toIndentedString(authorizedClerks)).append("\n");
		sb.append("    partners: ").append(toIndentedString(partners)).append("\n");
		sb.append("    registrationLegalDate: ").append(toIndentedString(registrationLegalDate)).append("\n");
		sb.append("    registrationDenialDate: ").append(toIndentedString(registrationDenialDate)).append("\n");
		sb.append("    registrationDenialBasis: ").append(toIndentedString(registrationDenialBasis)).append("\n");
		sb.append("    restorationDate: ").append(toIndentedString(restorationDate)).append("\n");
		sb.append("    restorationBasis: ").append(toIndentedString(restorationBasis)).append("\n");
		sb.append("    removalDate: ").append(toIndentedString(removalDate)).append("\n");
		sb.append("    removalBasis: ").append(toIndentedString(removalBasis)).append("\n");
		sb.append("    accountNumbers: ").append(toIndentedString(accountNumbers)).append("\n");
		sb.append("    hasVirtualAccounts: ").append(toIndentedString(hasVirtualAccounts)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
