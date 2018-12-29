package privat.houyi.com.demo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Create by zhuxiao on 2018/12/29 0029 13:33
 * email:xxxx
 */
public class Language implements Parcelable {
    private String name;
    private String learnDuration;
    private String intro;
    protected Language(Parcel in) {
        name = in.readString();
        learnDuration = in.readString();
        intro = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(learnDuration);
        dest.writeString(intro);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Language> CREATOR = new Creator<Language>() {
        @Override
        public Language createFromParcel(Parcel in) {
            return new Language(in);
        }

        @Override
        public Language[] newArray(int size) {
            return new Language[size];
        }
    };

    public Language(String name, String learnDuration, String intro) {
        this.name = name;
        this.learnDuration = learnDuration;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLearnDuration() {
        return learnDuration;
    }

    public void setLearnDuration(String learnDuration) {
        this.learnDuration = learnDuration;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


}
