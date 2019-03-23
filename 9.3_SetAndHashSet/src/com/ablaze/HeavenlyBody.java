//DESCRIPTION:
// A class HeavenlyBody with a set of HeavenlyBody
// objects that orbits it

package com.ablaze;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody
{
    //************ VARIABLES ************
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    //*********** CONSTRUCTORS **********
    HeavenlyBody(String name, double orbitalPeriod)
    {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        satellites = new HashSet<>();
    }

    //************* METHODS *************
    public boolean addMoon(HeavenlyBody moon)
    {
        return this.satellites.add(moon);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!=this.getClass())
            return false;
        return this.getName().equals(((HeavenlyBody)obj).getName());
    }

    @Override
    public int hashCode()
    {
        return this.getName().hashCode()+7;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String getName()
    {
        return name;
    }

    public double getOrbitalPeriod()
    {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites()
    {
        return new HashSet<>(satellites);
    }
}
