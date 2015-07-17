package org.lunifera.samples.carstore;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.lunifera.samples.carstore.Car;
import org.lunifera.samples.carstore.Length;

@Entity
@Table(name = "PICKUP")
@DiscriminatorValue(value = "PICKUP")
@SuppressWarnings("all")
public class Pickup extends Car {
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "amount", column = @Column(name = "LOADINGAREAWIDTH_AMOUNT")), @AttributeOverride(name = "siType", column = @Column(name = "LOADINGAREAWIDTH_SITYPE")) })
  @Column(name = "LOADING_AREA_WIDTH")
  private Length loadingAreaWidth;
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "amount", column = @Column(name = "LOADINGAREALENGTH_AMOUNT")), @AttributeOverride(name = "siType", column = @Column(name = "LOADINGAREALENGTH_SITYPE")) })
  @Column(name = "LOADING_AREA_LENGTH")
  private Length loadingAreaLength;
  
  /**
   * Checks whether the object is disposed.
   * @throws RuntimeException if the object is disposed.
   */
  private void checkDisposed() {
    if (isDisposed()) {
      throw new RuntimeException("Object already disposed: " + this);
    }
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br/>
   * If this object keeps composition containments, these will be disposed too. 
   * So the whole composition containment tree will be disposed on calling this method.
   */
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    super.dispose();
  }
  
  /**
   * Returns the loadingAreaWidth property or <code>null</code> if not present.
   */
  public Length getLoadingAreaWidth() {
    checkDisposed();
    return this.loadingAreaWidth;
  }
  
  /**
   * Sets the loadingAreaWidth property to this instance.
   */
  public void setLoadingAreaWidth(final Length loadingAreaWidth) {
    checkDisposed();
    this.loadingAreaWidth = loadingAreaWidth;
  }
  
  /**
   * Returns the loadingAreaLength property or <code>null</code> if not present.
   */
  public Length getLoadingAreaLength() {
    checkDisposed();
    return this.loadingAreaLength;
  }
  
  /**
   * Sets the loadingAreaLength property to this instance.
   */
  public void setLoadingAreaLength(final Length loadingAreaLength) {
    checkDisposed();
    this.loadingAreaLength = loadingAreaLength;
  }
}
