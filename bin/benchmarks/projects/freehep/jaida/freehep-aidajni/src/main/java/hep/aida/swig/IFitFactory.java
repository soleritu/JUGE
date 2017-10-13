/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package hep.aida.swig;
 
import hep.aida.jni.AIDAJNIUtil;

public class IFitFactory implements hep.aida.IFitFactory {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public IFitFactory(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(hep.aida.IFitFactory obj) {
    if (obj instanceof IFitFactory) {
      return (obj == null) ? 0 : ((IFitFactory)obj).swigCPtr;
    } else {
      long cPtr = AIDAJNI.new_IFitFactory();
      // FIXME, memory leak if Java class gets finalized, since C++ director is not freed.
      AIDAJNI.IFitFactory_director_connect(obj, cPtr, true, true);
      return cPtr;
    }
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      AIDAJNI.delete_IFitFactory(swigCPtr);
    }
    swigCPtr = 0;
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    AIDAJNI.IFitFactory_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    AIDAJNI.IFitFactory_change_ownership(this, swigCPtr, true);
  }

  public hep.aida.IFitData createFitData() {
    long cPtr = AIDAJNI.IFitFactory_createFitData(swigCPtr, this);
    return (cPtr == 0) ? null : new IFitData(cPtr, false);
  }

  public hep.aida.IFitter createFitter(String fitterType, String engineType, String options) {
    long cPtr = AIDAJNI.IFitFactory_createFitter__SWIG_0(swigCPtr, this, fitterType, engineType, options);
    return (cPtr == 0) ? null : new IFitter(cPtr, false);
  }

  public hep.aida.IFitter createFitter(String fitterType, String engineType) {
    long cPtr = AIDAJNI.IFitFactory_createFitter__SWIG_1(swigCPtr, this, fitterType, engineType);
    return (cPtr == 0) ? null : new IFitter(cPtr, false);
  }

  public hep.aida.IFitter createFitter(String fitterType) {
    long cPtr = AIDAJNI.IFitFactory_createFitter__SWIG_2(swigCPtr, this, fitterType);
    return (cPtr == 0) ? null : new IFitter(cPtr, false);
  }

  public hep.aida.IFitter createFitter() {
    long cPtr = AIDAJNI.IFitFactory_createFitter__SWIG_3(swigCPtr, this);
    return (cPtr == 0) ? null : new IFitter(cPtr, false);
  }

  public IFitFactory() {
    this(AIDAJNI.new_IFitFactory(), true);
    AIDAJNI.IFitFactory_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

}
