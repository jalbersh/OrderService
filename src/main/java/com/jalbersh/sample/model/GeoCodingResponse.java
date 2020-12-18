package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/*
{
    "info": {
        "statuscode": 0,
        "copyright": {
            "text": "© 2020 MapQuest, Inc.",
            "imageUrl": "http://api.mqcdn.com/res/mqlogo.gif",
            "imageAltText": "© 2020 MapQuest, Inc."
        },
        "messages": []
    },
    "options": {
        "maxResults": -1,
        "thumbMaps": true,
        "ignoreLatLngInput": false
    },
    "results": [
        {
            "providedLocation": {
                "location": "15193 W 63rd Ave, Arvada, CO 80403"
            },
            "locations": [
                {
                    "street": "15193 W 63rd Ave",
                    "adminArea6": "",
                    "adminArea6Type": "Neighborhood",
                    "adminArea5": "Arvada",
                    "adminArea5Type": "City",
                    "adminArea4": "Jefferson",
                    "adminArea4Type": "County",
                    "adminArea3": "CO",
                    "adminArea3Type": "State",
                    "adminArea1": "US",
                    "adminArea1Type": "Country",
                    "postalCode": "80403-7572",
                    "geocodeQualityCode": "P1AAA",
                    "geocodeQuality": "POINT",
                    "dragPoint": false,
                    "sideOfStreet": "L",
                    "linkId": "r10080861|p209832537|n12365365",
                    "unknownInput": "",
                    "type": "s",
                    "latLng": {
                        "lat": 39.807944,
                        "lng": -105.170345
                    },
                    "displayLatLng": {
                        "lat": 39.808179,
                        "lng": -105.17025
                    },
                    "mapUrl": "http://www.mapquestapi.com/staticmap/v5/map?key=CAhSuKNqSBZ1LyitrqhPsz1VnYoAm1TN&type=map&size=225,160&locations=39.807944,-105.170345|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-585183503"
                }
            ]
        }
    ]
}
 */
public class GeoCodingResponse {
    @JsonProperty("info")
    private Info info;

    @JsonProperty("options")
    private Options options;

    @JsonProperty("locations")
    private Locations locations;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoCodingResponse that = (GeoCodingResponse) o;
        return Objects.equals(info, that.info) &&
                Objects.equals(options, that.options) &&
                Objects.equals(locations, that.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, options, locations);
    }
}
