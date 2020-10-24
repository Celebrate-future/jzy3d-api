package org.jzy3d.plot3d.rendering.shaders;

import org.jzy3d.io.glsl.ShaderFilePair;
import org.jzy3d.painters.Painter;
import org.jzy3d.plot3d.primitives.AbstractDrawable;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;

public class ShadedDrawable extends Shaderable{
    AbstractDrawable drawable;
    
    public ShadedDrawable(AbstractDrawable drawable, ShaderFilePair shaders){
        this.drawable = drawable;
        this.shaders = shaders;
    }
    
    @Override
    public void display(Painter painter, GL2 gl, GLU glu) {
        executeProgram(painter, gl); 
        
        if(drawable!=null)
            drawable.draw(painter, gl, glu, null);
    }
}
