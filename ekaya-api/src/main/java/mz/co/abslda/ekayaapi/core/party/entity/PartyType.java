package mz.co.abslda.ekayaapi.core.party.entity;

/**
 * @author Ivo Abdul
 */
public enum PartyType {

	AUTOMATED_AGENT("Automated Agent"), FAMILY("Family"), GOVERNMENT_AGENCY("Government Agency"),
	INFORMAL_GROUP("Informal Group"), LEGAL_ORGANIZATION("Legal Organization"), PARTY_GROUP("Party Group"),
	PERSON("Person"), CITIZEN("Cidadão"), RESIDENCE("Residência"), TEAM("Team");

	private String description;

	private PartyType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}