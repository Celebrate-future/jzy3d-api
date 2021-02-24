package org.jzy3d.plot3d.text;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.BoundingBox3d;
import org.jzy3d.maths.Coord2d;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.painters.IPainter;
import org.jzy3d.plot3d.text.align.Halign;
import org.jzy3d.plot3d.text.align.Valign;
import org.jzy3d.plot3d.transform.space.SpaceTransformer;

public interface ITextRenderer {
  public BoundingBox3d drawText(IPainter painter, String s, Coord3d position, Halign halign, Valign valign, Color color);

  public BoundingBox3d drawText(IPainter painter, String s, Coord3d position, Halign halign, Valign valign, Color color, Coord2d screenOffset, Coord3d sceneOffset);

  public BoundingBox3d drawText(IPainter painter, String s, Coord3d position, Halign halign, Valign valign, Color color, Coord2d screenOffset);

  public BoundingBox3d drawText(IPainter painter, String s, Coord3d position, Halign halign, Valign valign, Color color, Coord3d sceneOffset);

  public SpaceTransformer getSpaceTransformer();

  public void setSpaceTransformer(SpaceTransformer transformer);
}
