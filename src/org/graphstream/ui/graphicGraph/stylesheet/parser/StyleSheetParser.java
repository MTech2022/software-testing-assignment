/* Generated By:JavaCC: Do not edit this line. StyleSheetParser.java */
/*
 * This file is part of GraphStream.
 * 
 * GraphStream is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * GraphStream is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with GraphStream.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright 2006 - 2009
 * 	Julien Baudry
 * 	Antoine Dutot
 * 	Yoann Pigné
 * 	Guilhelm Savin
 */

package org.graphstream.ui.graphicGraph.stylesheet.parser;

import java.awt.Color;
import java.io.InputStream;
import java.io.Reader;

import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.graphicGraph.stylesheet.Rule;
import org.graphstream.ui.graphicGraph.stylesheet.Selector;
import org.graphstream.ui.graphicGraph.stylesheet.Style;
import org.graphstream.ui.graphicGraph.stylesheet.StyleSheet;

@SuppressWarnings("all")
public class StyleSheetParser implements StyleSheetParserConstants {
        /**
	 * The style sheet.
	 */
        protected StyleSheet stylesheet;

        public StyleSheetParser( StyleSheet stylesheet, InputStream stream )
        {
                this( stream );
                this.stylesheet = stylesheet;
        }

        public StyleSheetParser( StyleSheet stylesheet, Reader stream )
        {
                this( stream );
                this.stylesheet = stylesheet;
        }

        public static class Number
        {
                public float value;
                public Style.Units units = Style.Units.PX;
                public Number( float value, Style.Units units ) { this.value=value; this.units = units; }
        }

/*
 * The parser.
 */
  final public void start() throws ParseException {
        Rule r;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GRAPH:
      case EDGE:
      case NODE:
      case SPRITE:
      case COMMENT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GRAPH:
      case EDGE:
      case NODE:
      case SPRITE:
        r = rule();
                     stylesheet.addRule( r );
        break;
      case COMMENT:
        jj_consume_token(COMMENT);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
  }

  final public Rule rule() throws ParseException {
        Selector select;
        Style    style;
        Rule     rule;
    select = select();
                rule  = new Rule( select );
                style = new Style();
                rule.setStyle( style );
    jj_consume_token(LBRACE);
    styles(style);
    jj_consume_token(RBRACE);
          {if (true) return rule;}
    throw new Error("Missing return statement in function");
  }

  final public void styles(Style style) throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ARROWIMGURL:
      case ARROWLENGTH:
      case ARROWSHAPE:
      case ARROWWIDTH:
      case BGCOLOR:
      case BORDERCOLOR:
      case BORDERWIDTH:
      case COLOR:
      case NODESHAPE:
      case EDGESHAPE:
      case EDGESTYLE:
      case HEIGHT:
      case IMAGEMODE:
      case IMAGEOFFSET:
      case PADDING:
      case SHADOWSTYLE:
      case SHADOWWIDTH:
      case SHADOWOFFSET:
      case SHADOWCOLOR:
      case SPRITESHAPE:
      case SPRITEORIENT:
      case TEXTALIGN:
      case TEXTCOLOR:
      case TEXTMODE:
      case TEXTSTYLE:
      case TEXTFONT:
      case TEXTSIZE:
      case TEXTOFFSET:
      case WIDTH:
      case ZINDEX:
      case IMAGE:
      case COMMENT:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      style(style);
    }
  }

  final public Selector select() throws ParseException {
        Token    t;
        Selector select;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GRAPH:
      jj_consume_token(GRAPH);
                       select=new Selector( Selector.Type.GRAPH );
      break;
    case NODE:
      jj_consume_token(NODE);
                       select=new Selector( Selector.Type.NODE );
      break;
    case EDGE:
      jj_consume_token(EDGE);
                       select=new Selector( Selector.Type.EDGE );
      break;
    case SPRITE:
      jj_consume_token(SPRITE);
                       select=new Selector( Selector.Type.SPRITE );
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DOT:
    case SHARP:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SHARP:
        jj_consume_token(SHARP);
        t = jj_consume_token(IDENTIFIER);
                                     select.setId(    t.image );
        break;
      case DOT:
        jj_consume_token(DOT);
        t = jj_consume_token(IDENTIFIER);
                                     select.setClass( t.image );
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLON:
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLICKED:
        jj_consume_token(CLICKED);
                                       select.setPseudoClass( "clicked"  );
        break;
      case SELECTED:
        jj_consume_token(SELECTED);
                                       select.setPseudoClass( "selected" );
        break;
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
                                       select.setPseudoClass( t.image    );
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
          {if (true) return select;}
    throw new Error("Missing return statement in function");
  }

  final public void style(Style style) throws ParseException {
        Color               color;
        String              url;
        Style.ArrowShape    arrow;
        Style.NodeShape     nshap;
        Style.EdgeShape     eshap;
        Style.EdgeStyle     estyl;
        Style.SpriteShape   sshap;
        Style.SpriteOrientation sori;
        Number              nb1, nb2;
        Style.TextAlignment txtal;
        Style.TextStyle     txtst;
        Style.TextMode      txtmd;
        Style.ImageMode     imm;
        Style.ShadowStyle   shsty;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMENT:
      jj_consume_token(COMMENT);
      break;
    case COLOR:
      jj_consume_token(COLOR);
      jj_consume_token(COLON);
      colors(style);
      jj_consume_token(SEMICOLON);
      break;
    case BGCOLOR:
      jj_consume_token(BGCOLOR);
      jj_consume_token(COLON);
      bgColors(style);
      jj_consume_token(SEMICOLON);
      break;
    case WIDTH:
      jj_consume_token(WIDTH);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setWidth( nb1.value, nb1.units );
      break;
    case HEIGHT:
      jj_consume_token(HEIGHT);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setHeight( nb1.value, nb1.units );
      break;
    case NODESHAPE:
      jj_consume_token(NODESHAPE);
      jj_consume_token(COLON);
      nshap = nodeShape();
      jj_consume_token(SEMICOLON);
                                                                             style.setNodeShape( nshap );
      break;
    case EDGESHAPE:
      jj_consume_token(EDGESHAPE);
      jj_consume_token(COLON);
      eshap = edgeShape(style);
      jj_consume_token(SEMICOLON);
                                                                             style.setEdgeShape( eshap );
      break;
    case EDGESTYLE:
      jj_consume_token(EDGESTYLE);
      jj_consume_token(COLON);
      estyl = edgeStyle();
      jj_consume_token(SEMICOLON);
                                                                             style.setEdgeStyle( estyl );
      break;
    case SPRITESHAPE:
      jj_consume_token(SPRITESHAPE);
      jj_consume_token(COLON);
      sshap = spriteShape();
      jj_consume_token(SEMICOLON);
                                                                             style.setSpriteShape( sshap );
      break;
    case SPRITEORIENT:
      jj_consume_token(SPRITEORIENT);
      jj_consume_token(COLON);
      sori = spriteOrient();
      jj_consume_token(SEMICOLON);
                                                                             style.setSpriteOrientation( sori );
      break;
    case ARROWSHAPE:
      jj_consume_token(ARROWSHAPE);
      jj_consume_token(COLON);
      arrow = arrowShape();
      jj_consume_token(SEMICOLON);
                                                                             style.setArrowShape( arrow );
      break;
    case ARROWLENGTH:
      jj_consume_token(ARROWLENGTH);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setArrowLength( nb1.value, nb1.units );
      break;
    case ARROWWIDTH:
      jj_consume_token(ARROWWIDTH);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setArrowWidth( nb1.value, nb1.units );
      break;
    case ARROWIMGURL:
      jj_consume_token(ARROWIMGURL);
      jj_consume_token(COLON);
      url = url();
      jj_consume_token(SEMICOLON);
                                                                             style.setArrowImageUrl( url );
      break;
    case BORDERCOLOR:
      jj_consume_token(BORDERCOLOR);
      jj_consume_token(COLON);
      color = color();
      jj_consume_token(SEMICOLON);
                                                                             style.setBorderColor( color );
      break;
    case BORDERWIDTH:
      jj_consume_token(BORDERWIDTH);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setBorderWidth( nb1.value, nb1.units );
      break;
    case IMAGE:
      jj_consume_token(IMAGE);
      jj_consume_token(COLON);
      url = url();
      jj_consume_token(SEMICOLON);
                                                                             style.setImageUrl( url );
      break;
    case IMAGEMODE:
      jj_consume_token(IMAGEMODE);
      jj_consume_token(COLON);
      imm = imageMode();
      jj_consume_token(SEMICOLON);
                                                                             style.setImageMode( imm );
      break;
    case IMAGEOFFSET:
      jj_consume_token(IMAGEOFFSET);
      jj_consume_token(COLON);
      nb1 = real();
      nb2 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setImageOffset( nb1.value, nb2.value, nb1.units );
      break;
    case PADDING:
      jj_consume_token(PADDING);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setPadding( nb1.value, nb1.units );
      break;
    case SHADOWSTYLE:
      jj_consume_token(SHADOWSTYLE);
      jj_consume_token(COLON);
      shsty = shadowStyle();
      jj_consume_token(SEMICOLON);
                                                                             style.setShadowStyle( shsty );
      break;
    case SHADOWOFFSET:
      jj_consume_token(SHADOWOFFSET);
      jj_consume_token(COLON);
      nb1 = real();
      nb2 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setShadowOffset( nb1.value, nb2.value, nb1.units );
      break;
    case SHADOWCOLOR:
      jj_consume_token(SHADOWCOLOR);
      jj_consume_token(COLON);
      shadowColors(style);
      jj_consume_token(SEMICOLON);
      break;
    case SHADOWWIDTH:
      jj_consume_token(SHADOWWIDTH);
      jj_consume_token(COLON);
      nb1 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setShadowWidth( nb1.value, nb1.units );
      break;
    case TEXTALIGN:
      jj_consume_token(TEXTALIGN);
      jj_consume_token(COLON);
      txtal = textAlign();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextAlignment( txtal );
      break;
    case TEXTMODE:
      jj_consume_token(TEXTMODE);
      jj_consume_token(COLON);
      txtmd = textMode();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextMode( txtmd );
      break;
    case TEXTCOLOR:
      jj_consume_token(TEXTCOLOR);
      jj_consume_token(COLON);
      color = color();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextColor( color );
      break;
    case TEXTSTYLE:
      jj_consume_token(TEXTSTYLE);
      jj_consume_token(COLON);
      txtst = textStyle();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextStyle( txtst );
      break;
    case TEXTFONT:
      jj_consume_token(TEXTFONT);
      jj_consume_token(COLON);
      url = font();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextFont( url );
      break;
    case TEXTSIZE:
      jj_consume_token(TEXTSIZE);
      jj_consume_token(COLON);
      nb1 = integer();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextSize( (int)nb1.value );
      break;
    case TEXTOFFSET:
      jj_consume_token(TEXTOFFSET);
      jj_consume_token(COLON);
      nb1 = real();
      nb2 = real();
      jj_consume_token(SEMICOLON);
                                                                             style.setTextOffset( nb1.value, nb2.value, nb1.units );
      break;
    case ZINDEX:
      jj_consume_token(ZINDEX);
      jj_consume_token(COLON);
      nb1 = integer();
      jj_consume_token(SEMICOLON);
                                                                             style.setZIndex( (int)nb1.value );
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void colors(Style style) throws ParseException {
        Color color;
        style.unsetColor();
    label_3:
    while (true) {
      color = color();
                            style.addColor( color );
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RGBA:
      case RGB:
      case HTMLCOLOR:
      case STRING:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
    }
  }

  final public void bgColors(Style style) throws ParseException {
        Color color;
        style.unsetBgColor();
    label_4:
    while (true) {
      color = color();
                            style.addBackgroundColor( color );
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RGBA:
      case RGB:
      case HTMLCOLOR:
      case STRING:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_4;
      }
    }
  }

  final public void shadowColors(Style style) throws ParseException {
        Color color;
        style.unsetShadowColor();
    label_5:
    while (true) {
      color = color();
                            style.addShadowColor( color );
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RGBA:
      case RGB:
      case HTMLCOLOR:
      case STRING:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_5;
      }
    }
  }

  final public Number integer() throws ParseException {
        Token       t;
        Style.Units units = Style.Units.PX;
        Number      n     = null;
    t = jj_consume_token(REAL);
                String nb = t.image.toLowerCase();

                if( nb.endsWith( "px" ) )
                {
                        units = Style.Units.PX;
                        nb    = nb.substring( 0, nb.length()-2 );
                }
                else if( nb.endsWith( "gu" ) )
                {
                        units = Style.Units.GU;
                        nb    = nb.substring( 0, nb.length()-2 );
                }
                else if( nb.endsWith( "%" ) )
                {
                        units = Style.Units.PERCENTS;
                        nb    = nb.substring( 0, nb.length()-1 );
                }

                try { n = new Number( Float.parseFloat( nb ), units ); }
                catch( NumberFormatException e ) { generateParseException(); }
                {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  final public Number real() throws ParseException {
        Token       t;
        Style.Units units = Style.Units.PX;
        Number      n     = null;
    t = jj_consume_token(REAL);
                String nb = t.image.toLowerCase();

                if( nb.endsWith( "px" ) )
                {
                        units = Style.Units.PX;
                        nb    = nb.substring( 0, nb.length()-2 );
                }
                else if( nb.endsWith( "gu" ) )
                {
                        units = Style.Units.GU;
                        nb    = nb.substring( 0, nb.length()-2 );
                }
                else if( nb.endsWith( "%" ) )
                {
                        units = Style.Units.PERCENTS;
                        nb    = nb.substring( 0, nb.length()-1 );
                }

                try{ n = new Number( Float.parseFloat( nb ), units ); }
                catch( NumberFormatException e ) { generateParseException(); }
                {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  final public Color color() throws ParseException {
        Token  t;
        String s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RGB:
      t = jj_consume_token(RGB);
                             s = t.image;
      break;
    case RGBA:
      t = jj_consume_token(RGBA);
                             s = t.image;
      break;
    case HTMLCOLOR:
      t = jj_consume_token(HTMLCOLOR);
                             s = t.image;
      break;
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                             s = t.image;
      break;
    case STRING:
      t = jj_consume_token(STRING);
                             s = t.image.substring( 1, t.image.length()-1 );
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                Color color = GraphicGraph.convertColor( s );
                if( color == null ) color = Color.BLACK;
                {if (true) return color;}
    throw new Error("Missing return statement in function");
  }

  final public Style.ArrowShape arrowShape() throws ParseException {
        Style.ArrowShape s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NONE:
      jj_consume_token(NONE);
                        s = Style.ArrowShape.NONE;
      break;
    case SIMPLE:
      jj_consume_token(SIMPLE);
                        s = Style.ArrowShape.SIMPLE;
      break;
    case DIAMANT:
      jj_consume_token(DIAMANT);
                        s = Style.ArrowShape.DIAMANT;
      break;
    case CIRCLE:
      jj_consume_token(CIRCLE);
                        s = Style.ArrowShape.CIRCLE;
      break;
    case IMAGE:
      jj_consume_token(IMAGE);
                        s = Style.ArrowShape.IMAGE;
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public Style.SpriteShape spriteShape() throws ParseException {
        Style.SpriteShape s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CIRCLE:
      jj_consume_token(CIRCLE);
                            s = Style.SpriteShape.CIRCLE;
      break;
    case IMAGE:
      jj_consume_token(IMAGE);
                            s = Style.SpriteShape.IMAGE;
      break;
    case IMAGES:
      jj_consume_token(IMAGES);
                            s = Style.SpriteShape.IMAGES;
      break;
    case ARROW:
      jj_consume_token(ARROW);
                            s = Style.SpriteShape.ARROW;
      break;
    case FLOW:
      jj_consume_token(FLOW);
                            s = Style.SpriteShape.FLOW;
      break;
    case PIE_CHART:
      jj_consume_token(PIE_CHART);
                            s = Style.SpriteShape.PIE_CHART;
      break;
    case TEXTBOX:
      jj_consume_token(TEXTBOX);
                            s = Style.SpriteShape.TEXT_BOX;
      break;
    case TEXTELLIPSE:
      jj_consume_token(TEXTELLIPSE);
                            s = Style.SpriteShape.TEXT_ELLIPSE;
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public Style.SpriteOrientation spriteOrient() throws ParseException {
        Style.SpriteOrientation s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NONE:
      jj_consume_token(NONE);
                       s = Style.SpriteOrientation.NONE;
      break;
    case TO:
      jj_consume_token(TO);
                       s = Style.SpriteOrientation.TO;
      break;
    case FROM:
      jj_consume_token(FROM);
                       s = Style.SpriteOrientation.FROM;
      break;
    case ORIGIN:
      jj_consume_token(ORIGIN);
                       s = Style.SpriteOrientation.ORIGIN;
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public String url() throws ParseException {
        Token t;
    jj_consume_token(URL);
    jj_consume_token(LPAREN);
    t = jj_consume_token(STRING);
    jj_consume_token(RPAREN);
          {if (true) return t.image.substring( 1, t.image.length()-1 );}
    throw new Error("Missing return statement in function");
  }

  final public String font() throws ParseException {
        Token  t;
        String s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                             s = t.image;
      break;
    case STRING:
      t = jj_consume_token(STRING);
                             s = t.image.substring( 1, t.image.length()-1 );
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public Style.NodeShape nodeShape() throws ParseException {
        Style.NodeShape s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SQUARE:
      jj_consume_token(SQUARE);
                            s = Style.NodeShape.SQUARE;
      break;
    case CIRCLE:
      jj_consume_token(CIRCLE);
                            s = Style.NodeShape.CIRCLE;
      break;
    case TRIANGLE:
      jj_consume_token(TRIANGLE);
                            s = Style.NodeShape.TRIANGLE;
      break;
    case CROSS:
      jj_consume_token(CROSS);
                            s = Style.NodeShape.CROSS;
      break;
    case TEXTBOX:
      jj_consume_token(TEXTBOX);
                            s = Style.NodeShape.TEXT_BOX;
      break;
    case TEXTELLIPSE:
      jj_consume_token(TEXTELLIPSE);
                            s = Style.NodeShape.TEXT_ELLIPSE;
      break;
    case IMAGE:
      jj_consume_token(IMAGE);
                            s = Style.NodeShape.IMAGE;
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public Style.EdgeShape edgeShape(Style style) throws ParseException {
        Style.EdgeShape s;
        Number nb1, nb2, nb3;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LINE:
      jj_consume_token(LINE);
                           s = Style.EdgeShape.LINE;
      break;
    case ANGLE:
      jj_consume_token(ANGLE);
                           s = Style.EdgeShape.ANGLE;
      break;
    case CUBICCURVE:
      jj_consume_token(CUBICCURVE);
                           s = Style.EdgeShape.CUBIC_CURVE;
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
                       s = Style.EdgeShape.POINTS;
      nb1 = real();
      jj_consume_token(COMA);
      nb2 = real();
      jj_consume_token(COMA);
      nb3 = real();
      jj_consume_token(RPAREN);
                                                                                                                      style.removeEdgePoints(); style.addEdgePoint( nb1.value, nb2.value, nb3.value );
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMA:
          ;
          break;
        default:
          jj_la1[18] = jj_gen;
          break label_6;
        }
        jj_consume_token(COMA);
        jj_consume_token(LPAREN);
        nb1 = real();
        jj_consume_token(COMA);
        nb2 = real();
        jj_consume_token(COMA);
        nb3 = real();
        jj_consume_token(RPAREN);
                                                                                                                     style.addEdgePoint(  nb1.value, nb2.value, nb3.value );
      }
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public Style.EdgeStyle edgeStyle() throws ParseException {
        Style.EdgeStyle s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLAIN:
      jj_consume_token(PLAIN);
                           s = Style.EdgeStyle.PLAIN;
      break;
    case DOTS:
      jj_consume_token(DOTS);
                           s = Style.EdgeStyle.DOTS;
      break;
    case DASHES:
      jj_consume_token(DASHES);
                           s = Style.EdgeStyle.DASHES;
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public Style.ImageMode imageMode() throws ParseException {
        Style.ImageMode m;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SIMPLE:
      jj_consume_token(SIMPLE);
                       m = Style.ImageMode.SIMPLE;
      break;
    case TILED:
      jj_consume_token(TILED);
                       m = Style.ImageMode.TILED;
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return m;}
    throw new Error("Missing return statement in function");
  }

  final public Style.TextAlignment textAlign() throws ParseException {
        Style.TextAlignment t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFT:
      jj_consume_token(LEFT);
                       t = Style.TextAlignment.LEFT;
      break;
    case RIGHT:
      jj_consume_token(RIGHT);
                       t = Style.TextAlignment.RIGHT;
      break;
    case CENTER:
      jj_consume_token(CENTER);
                       t = Style.TextAlignment.CENTER;
      break;
    case ASIDE:
      jj_consume_token(ASIDE);
                       t = Style.TextAlignment.ASIDE;
      break;
    case ALONG:
      jj_consume_token(ALONG);
                       t = Style.TextAlignment.ALONG;
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  final public Style.TextStyle textStyle() throws ParseException {
        Style.TextStyle t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NORMAL:
      jj_consume_token(NORMAL);
                            t = Style.TextStyle.NORMAL;
      break;
    case BOLD:
      jj_consume_token(BOLD);
                            t = Style.TextStyle.BOLD;
      break;
    case ITALIC:
      jj_consume_token(ITALIC);
                            t = Style.TextStyle.ITALIC;
      break;
    case BOLD_ITALIC:
      jj_consume_token(BOLD_ITALIC);
                            t = Style.TextStyle.BOLD_ITALIC;
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  final public Style.TextMode textMode() throws ParseException {
        Style.TextMode m;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NORMAL:
      jj_consume_token(NORMAL);
                          m = Style.TextMode.NORMAL;
      break;
    case HIDDEN:
      jj_consume_token(HIDDEN);
                          m = Style.TextMode.HIDDEN;
      break;
    case TRUNCATED:
      jj_consume_token(TRUNCATED);
                          m = Style.TextMode.TRUNCATED;
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return m;}
    throw new Error("Missing return statement in function");
  }

  final public Style.ShadowStyle shadowStyle() throws ParseException {
        Style.ShadowStyle s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NONE:
      jj_consume_token(NONE);
                           s = Style.ShadowStyle.NONE;
      break;
    case SIMPLE:
      jj_consume_token(SIMPLE);
                           s = Style.ShadowStyle.SIMPLE;
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  public StyleSheetParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[26];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
      jj_la1_3();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0xf000000,0xf000000,0xf0000000,0xf000000,0x4200,0x4200,0x0,0x8000,0xf0000000,0x5c0000,0x5c0000,0x5c0000,0x5c0000,0x0,0x0,0x0,0x400000,0x0,0x20000,0x1000,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x7fffffb,0x0,0x0,0x0,0x0,0x0,0x7fffffb,0x0,0x0,0x0,0x0,0x0,0x20000000,0x0,0x0,0x0,0x0,0x10000000,0x0,0x0,0x48000000,0x80000000,0x0,0x0,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x2000,0x0,0x0,0x0,0x800008,0x0,0x2000,0x0,0x0,0x0,0x0,0x1042084,0x4c006204,0x80140400,0x0,0x1e002014,0x0,0x20020,0x200140,0x21000000,0x410002,0x88001,0x81800,0x1040000,};
   }
   private static void jj_la1_3() {
      jj_la1_3 = new int[] {0x2,0x2,0x2,0x0,0x0,0x0,0x1,0x0,0x2,0x1,0x1,0x1,0x1,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  public StyleSheetParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public StyleSheetParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new StyleSheetParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public StyleSheetParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new StyleSheetParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public StyleSheetParser(StyleSheetParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public void ReInit(StyleSheetParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector<int[]> jj_expentries = new java.util.Vector<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[98];
    for (int i = 0; i < 98; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 26; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 98; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}
