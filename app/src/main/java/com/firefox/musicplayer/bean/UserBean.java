package com.firefox.musicplayer.bean;

import java.util.List;

/**
 * Created by FireFox on 2017/4/22.
 */

public class UserBean {

    /**
     * loginType : 1
     * code : 200
     * account : {"id":52934915,"userName":"0_zjsszbd@126.com","type":0,"status":0,"whitelistAuthority":0,"createTime":0,"salt":"","tokenVersion":0,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * profile : {"avatarImgIdStr":"3419481162584799","backgroundImgIdStr":"2002210674180202","userId":52934915,"province":420000,"expertTags":null,"avatarImgId":3419481162584799,"backgroundImgId":2002210674180202,"vipType":0,"authStatus":0,"accountStatus":0,"nickname":"309637962","defaultAvatar":false,"avatarUrl":"http://p1.music.126.net/LNkAuPiPhnr8sPahB7cFtQ==/3419481162584799.jpg","gender":1,"birthday":788889600000,"city":420900,"userType":0,"backgroundUrl":"http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg","remarkName":null,"mutual":false,"detailDescription":"","djStatus":0,"followed":false,"description":"","signature":"建建","authority":0}
     * bindings : [{"url":"","userId":52934915,"tokenJsonStr":"{\"cellphone\":\"13163388532\",\"hasPassword\":true}","expired":false,"refreshTime":1433425286,"expiresIn":2147483647,"id":34392329,"type":1},{"url":"http://t.qq.com/zjsszbd2006","userId":52934915,"tokenJsonStr":"{\"openkey\":\"24344CDB41C6C846F9F2E811F3DFC67D\",\"nick\":\"张建升\",\"name\":\"zjsszbd2006\",\"openid\":\"aef3bfd6e6673dbbe6c5c44056e360b9\",\"expires_in\":8035200,\"refresh_token\":\"db658f236d8d43b4d8741a8dbae4f796\",\"access_token\":\"ffcf399a483dacec7b63107abef8dd25\",\"openId\":\"AEF3BFD6E6673DBBE6C5C44056E360B9\"}","expired":true,"refreshTime":1436956901,"expiresIn":8035200,"id":37611422,"type":6},{"url":"","userId":52934915,"tokenJsonStr":"{\"access_token\":\"48B461E507C97C81A9C9E8582C0C7C5C\",\"refresh_token\":\"9E76179CE858E9A18F3B36BD463BA2F7\",\"openid\":\"C9F9B50B79BB21A4904E9BDB777042E9\",\"nickname\":\"disillusion\",\"expires_in\":7776000}","expired":true,"refreshTime":1482994447,"expiresIn":7776000,"id":2944680117,"type":5},{"url":"","userId":52934915,"tokenJsonStr":"{\"email\":\"zjsszbd@126.com\"}","expired":false,"refreshTime":0,"expiresIn":2147483647,"id":26503104,"type":0}]
     */

    private int loginType;
    private int code;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 52934915
         * userName : 0_zjsszbd@126.com
         * type : 0
         * status : 0
         * whitelistAuthority : 0
         * createTime : 0
         * salt :
         * tokenVersion : 0
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */

        private int id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private int createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private int viptypeVersion;
        private boolean anonimousUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }
    }

    public static class ProfileBean {
        /**
         * avatarImgIdStr : 3419481162584799
         * backgroundImgIdStr : 2002210674180202
         * userId : 52934915
         * province : 420000
         * expertTags : null
         * avatarImgId : 3419481162584799
         * backgroundImgId : 2002210674180202
         * vipType : 0
         * authStatus : 0
         * accountStatus : 0
         * nickname : 309637962
         * defaultAvatar : false
         * avatarUrl : http://p1.music.126.net/LNkAuPiPhnr8sPahB7cFtQ==/3419481162584799.jpg
         * gender : 1
         * birthday : 788889600000
         * city : 420900
         * userType : 0
         * backgroundUrl : http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg
         * remarkName : null
         * mutual : false
         * detailDescription :
         * djStatus : 0
         * followed : false
         * description :
         * signature : 建建
         * authority : 0
         */

        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private int userId;
        private int province;
        private Object expertTags;
        private long avatarImgId;
        private long backgroundImgId;
        private int vipType;
        private int authStatus;
        private int accountStatus;
        private String nickname;
        private boolean defaultAvatar;
        private String avatarUrl;
        private int gender;
        private long birthday;
        private int city;
        private int userType;
        private String backgroundUrl;
        private Object remarkName;
        private boolean mutual;
        private String detailDescription;
        private int djStatus;
        private boolean followed;
        private String description;
        private String signature;
        private int authority;

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }
    }

    public static class BindingsBean {
        /**
         * url :
         * userId : 52934915
         * tokenJsonStr : {"cellphone":"13163388532","hasPassword":true}
         * expired : false
         * refreshTime : 1433425286
         * expiresIn : 2147483647
         * id : 34392329
         * type : 1
         */

        private String url;
        private int userId;
        private String tokenJsonStr;
        private boolean expired;
        private int refreshTime;
        private int expiresIn;
        private int id;
        private int type;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
