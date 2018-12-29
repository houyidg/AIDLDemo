// IMyAidlInterface.aidl
package privat.houyi.com.demo;
import privat.houyi.com.demo.entity.Language;
import privat.houyi.com.demo.IScheduleListener;

// Declare any non-default types here with import statements
interface IScheduleManager {
    void study(in Language language);
    void forget(in Language language);
    void schedule(IScheduleListener listener);
}
