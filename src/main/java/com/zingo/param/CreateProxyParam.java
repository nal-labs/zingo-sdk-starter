package com.zingo.param;

import com.zingo.request.CreateProxyRequest;

/**
 * @author manta
 * @since 2024/11/18
 */
public class CreateProxyParam extends BaseParam {
    private String ipAddress;

    private String firstName;

    private String lastName;

    private Boolean isPremium;

    private Boolean addedToAttachmentMenu;

    private Boolean allowsWriteToPm;

    private Boolean isBot;

    private String languageCode;

    private String photoUrl;

    private String username;
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public Boolean getAddedToAttachmentMenu() {
        return addedToAttachmentMenu;
    }

    public void setAddedToAttachmentMenu(Boolean addedToAttachmentMenu) {
        this.addedToAttachmentMenu = addedToAttachmentMenu;
    }

    public Boolean getAllowsWriteToPm() {
        return allowsWriteToPm;
    }

    public void setAllowsWriteToPm(Boolean allowsWriteToPm) {
        this.allowsWriteToPm = allowsWriteToPm;
    }

    public Boolean getBot() {
        return isBot;
    }

    public void setBot(Boolean bot) {
        isBot = bot;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CreateProxyParam{" +
                "ipAddress='" + ipAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isPremium=" + isPremium +
                ", addedToAttachmentMenu=" + addedToAttachmentMenu +
                ", allowsWriteToPm=" + allowsWriteToPm +
                ", isBot=" + isBot +
                ", languageCode='" + languageCode + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public CreateProxyParam(CreateProxyRequest request) {
        this.ipAddress = request.getIpAddress();
        this.setTgId(request.getTgId());
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.isPremium = request.getPremium();
        this.addedToAttachmentMenu = request.getAddedToAttachmentMenu();
        this.allowsWriteToPm = request.getAllowsWriteToPm();
        this.isBot = request.getBot();
        this.languageCode = request.getLanguageCode();
        this.photoUrl = request.getPhotoUrl();
        this.username = request.getUsername();
    }
}
