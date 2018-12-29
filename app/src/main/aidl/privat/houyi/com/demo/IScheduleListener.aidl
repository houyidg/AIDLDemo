// IMyAidlInterface.aidl
package privat.houyi.com.demo;
import privat.houyi.com.demo.entity.Language;

// Declare any non-default types here with import statements
interface IScheduleListener {
    void studyPrev(in Language language);
}
