//DESCRIPTION: Set and HashSet in Java
//DATE: 03/06/2019

package com.ablaze;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main
{
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args)
    {
        //a method to add various planets and their moons
        addHeavenlyBodies();

        //Print all planets
        System.out.println("Planets");
        for(HeavenlyBody h : planets)
            System.out.println("\t"+h.getName()+" - "+h.getOrbitalPeriod());
        System.out.println();

        //create a method to print all moons
        //for the planet passing its name as argument
        printAllMoons("Jupiter");

        //create a set of all the moons and print it
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody h : planets)
            moons.addAll(h.getSatellites());
        System.out.println("All moons:");
        for(HeavenlyBody h : moons)
            System.out.println("\t"+h.getName());
    }

    private static void printAllMoons(String planet)
    {
        Set<HeavenlyBody> moons = solarSystem.get(planet).getSatellites();
        System.out.println("Moons of "+planet);
        for(HeavenlyBody h : moons)
            System.out.println("\t"+h.getName());
    }

    private static void addHeavenlyBodies()
    {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //the following object will not be added to hashset of planet
        //since temp will hash to the same bucket where previous pluto
        //is located and thus prevents the duplicate values
        temp = new HeavenlyBody("Pluto", 247);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
    }
}
