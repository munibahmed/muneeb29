/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muneebapi; 
 
import java.awt.Color; 
import java.util.ArrayList; 
 
/**
 * @author muneeb  
 */ 
public class DefaultColorFieldModel implements ColorFieldModel { 
 private ArrayList<ColorChangeListener> listeners = new ArrayList<ColorChangeListener>(); 
 private Color color; 
 
 /**
  *  
  */ 
 public DefaultColorFieldModel() { 
  color = new Color(255, 255, 255); 
 } 
 
 /**
  * @param color 
  */ 
 public DefaultColorFieldModel(final Color color) { 
  if (color == null) { 
   throw new NullPointerException("color == null"); 
  } 
  this.color = color; 
 } 
 
 /**
  * @see java.lang.Object#finalize() 
  */ 
 @Override 
 public void finalize() throws Throwable { 
  color = null; 
  listeners.clear(); 
  listeners = null; 
  super.finalize(); 
 } 
 
 
 public void addColorChangeListener(final ColorChangeListener listener) { 
  listeners.add(listener); 
 } 
 
  
 public void removeColorChangeListener(final ColorChangeListener listener) { 
  listeners.remove(listener); 
 } 
 
 /**
  * @param e 
  */ 
 protected void fireColorChangeEvent(final ColorChangeEvent e) { 
  for (final ColorChangeListener listener : listeners) { 
   listener.colorChanged(e); 
  } 
 } 
 
 /**
  
  */ 
 public void setColor(final Color color, final boolean isAdjusting) { 
  if (color == null) { 
   throw new NullPointerException("color == null"); 
  } 
  if ((this.color != color) && (this.color.getRGB() != color.getRGB())) { 
   this.color = color; 
   fireColorChangeEvent(new ColorChangeEvent(this, isAdjusting)); 
  } 
 } 
 

 public Color getColor() { 
  return color; 
 } 
}