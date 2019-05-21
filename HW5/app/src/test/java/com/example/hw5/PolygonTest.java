package com.example.hw5;

import android.content.Context;

import com.google.common.truth.Truth;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PolygonTest {


    Polygon testPoly;

    @Mock
    Context mockContext;

    @Before
    public void setUp(){
        this.testPoly = new Polygon(3,1,"Inches");

        MockitoAnnotations.initMocks(this);

        when(mockContext.getString(R.string.default_sides))
                .thenReturn("4");
        when(mockContext.getString(R.string.default_sideLength))
                .thenReturn("2");
        when(mockContext.getString(R.string.default_units))
                .thenReturn("Inches");
    }

    @Test
    public void polygon_changeSides_returnsCorrectValues(){

        int interiorAngle4sides = testPoly.changeSides(4);
        assertThat(interiorAngle4sides).isEqualTo(90);

        //edge case: If the user passes less than 3 it is changed to 3

        int interiorAngle2sides = testPoly.changeSides(2);
        assertThat(interiorAngle2sides).isEqualTo(60);

        int interiorAngle0sides = testPoly.changeSides(0);
        assertThat(interiorAngle0sides).isEqualTo(60);

        int interiorAngleNeg100sides = testPoly.changeSides(-100);
        assertThat(interiorAngleNeg100sides).isEqualTo(60);
    }

    @Test
    public void polygon_changeLengths_returnsCorrectValues(){
        int perimeter = testPoly.changeLength(2, "Inches");
        assertThat(perimeter).isEqualTo(6);

        int perimeter0 = testPoly.changeLength(0, "Inches");
        assertThat(perimeter0).isEqualTo(3);

        int perimeterNeg = testPoly.changeLength(-100, "Inches");
        assertThat(perimeterNeg).isEqualTo(3);
    }

    @Test
    public void polygon_defaultContextConstructor_returnsCorrectValues(){

        Polygon defaultPoly = new Polygon(mockContext);

        assertThat(defaultPoly.getSides()).isEqualTo(4);
        assertThat(defaultPoly.getSideLength()).isEqualTo(2);
        assertThat(defaultPoly.getUnits()).isEqualTo("Inches");

        defaultPoly.changeSides(3);
        defaultPoly.changeLength(4, "Feet");

        assertThat(defaultPoly.getDegrees()).isEqualTo(60);
        assertThat(defaultPoly.getPerimeter()).isEqualTo(12);
        assertThat(defaultPoly.getUnits()).isEqualTo("Feet");


    }

}
