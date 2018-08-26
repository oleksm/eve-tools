ALTER TABLE public."agtAgents" RENAME TO agtagent;
ALTER TABLE public."agtAgentTypes" RENAME TO agtagenttype;
ALTER TABLE public."agtResearchAgents" RENAME TO agtresearchagent;
ALTER TABLE public."chrAncestries" RENAME TO chrancestrie;
ALTER TABLE public."chrAttributes" RENAME TO chrattribute;
ALTER TABLE public."chrBloodlines" RENAME TO chrbloodline;
ALTER TABLE public."chrFactions" RENAME TO chrfaction;
ALTER TABLE public."chrRaces" RENAME TO chrrace;
ALTER TABLE public."crpActivities" RENAME TO crpactivitie;
ALTER TABLE public."crpNPCCorporationDivisions" RENAME TO crpnpccorporationdivision;
ALTER TABLE public."crpNPCCorporationResearchFields" RENAME TO crpnpccorporationresearchfield;
ALTER TABLE public."crpNPCCorporations" RENAME TO crpnpccorporation;
ALTER TABLE public."crpNPCCorporationTrades" RENAME TO crpnpccorporationtrade;
ALTER TABLE public."crpNPCDivisions" RENAME TO crpnpcdivision;
ALTER TABLE public."crtCertificates" RENAME TO crtcertificate;
ALTER TABLE public."crtCertificateSkills" RENAME TO crtcertificateskill;
ALTER TABLE public."crtMasteries" RENAME TO crtmasterie;
ALTER TABLE public."crtRecommendedTypes" RENAME TO crtrecommendedtype;
ALTER TABLE public."dgmAttributeCategories" RENAME TO dgmattributecategorie;
ALTER TABLE public."dgmAttributeTypes" RENAME TO dgmattributetype;
ALTER TABLE public."dgmEffects" RENAME TO dgmeffect;
ALTER TABLE public."dgmEffectsModifierInfo" RENAME TO dgmeffectsmodifierinfo;
ALTER TABLE public."dgmExpressions" RENAME TO dgmexpression;
ALTER TABLE public."dgmTypeAttributes" RENAME TO dgmtypeattribute;
ALTER TABLE public."dgmTypeEffects" RENAME TO dgmtypeeffect;
ALTER TABLE public."eveGraphics" RENAME TO evegraphic;
ALTER TABLE public."eveIcons" RENAME TO eveicon;
ALTER TABLE public."eveUnits" RENAME TO eveunit;
ALTER TABLE public."industryActivities" RENAME TO industryactivitie;
ALTER TABLE public."industryActivityMaterials" RENAME TO industryactivitymaterial;
ALTER TABLE public."industryActivityProducts" RENAME TO industryactivityproduct;
ALTER TABLE public."industryActivitySkills" RENAME TO industryactivityskill;
ALTER TABLE public."industryBlueprints" RENAME TO industryblueprint;
ALTER TABLE public."invCategories" RENAME TO invcategorie;
ALTER TABLE public."invContrabandTypes" RENAME TO invcontrabandtype;
ALTER TABLE public."invControlTowerResourcePurposes" RENAME TO invcontroltowerresourcepurpose;
ALTER TABLE public."invControlTowerResources" RENAME TO invcontroltowerresource;
ALTER TABLE public."invFlags" RENAME TO invflag;
ALTER TABLE public."invGroups" RENAME TO invgroup;
ALTER TABLE public."invItems" RENAME TO invitem;
ALTER TABLE public."invMarketGroups" RENAME TO invmarketgroup;
ALTER TABLE public."invMetaGroups" RENAME TO invmetagroup;
ALTER TABLE public."invMetaTypes" RENAME TO invmetatype;
ALTER TABLE public."invNames" RENAME TO invname;
ALTER TABLE public."invPositions" RENAME TO invposition;
ALTER TABLE public."invTraits" RENAME TO invtrait;
ALTER TABLE public."invTypeMaterials" RENAME TO invtypematerial;
ALTER TABLE public."invTypeReactions" RENAME TO invtypereaction;
ALTER TABLE public."invTypes" RENAME TO invtype;
ALTER TABLE public."invUniqueNames" RENAME TO invuniquename;
ALTER TABLE public."mapCelestialStatistics" RENAME TO mapcelestialstatistic;
ALTER TABLE public."mapConstellations" RENAME TO mapconstellation;
ALTER TABLE public."mapDenormalize" RENAME TO mapdenormalize;
ALTER TABLE public."mapDisallowedAnchorCategories" RENAME TO mapdisallowedanchorcategorie;
ALTER TABLE public."mapDisallowedAnchorGroups" RENAME TO mapdisallowedanchorgroup;
ALTER TABLE public."mapItemEffectBeacons" RENAME TO mapitemeffectbeacon;
ALTER TABLE public."mapJumps" RENAME TO mapjump;
ALTER TABLE public."mapLandmarks" RENAME TO maplandmark;
ALTER TABLE public."mapLocationScenes" RENAME TO maplocationscene;
ALTER TABLE public."mapLocationWormholeClasses" RENAME TO maplocationwormholeclasse;
ALTER TABLE public."mapRegions" RENAME TO mapregion;
ALTER TABLE public."mapSolarSystems" RENAME TO mapsolarsystem;
ALTER TABLE public."mapUniverse" RENAME TO mapuniverse;
ALTER TABLE public."planetSchematics" RENAME TO planetschematic;
ALTER TABLE public."planetSchematicsPinMap" RENAME TO planetschematicspinmap;
ALTER TABLE public."planetSchematicsTypeMap" RENAME TO planetschematicstypemap;
ALTER TABLE public."ramActivities" RENAME TO ramactivitie;
ALTER TABLE public."ramAssemblyLineStations" RENAME TO ramassemblylinestation;
ALTER TABLE public."ramAssemblyLineTypeDetailPerCategory" RENAME TO ramassemblylinetypedetailpercategory;
ALTER TABLE public."ramAssemblyLineTypeDetailPerGroup" RENAME TO ramassemblylinetypedetailpergroup;
ALTER TABLE public."ramAssemblyLineTypes" RENAME TO ramassemblylinetype;
ALTER TABLE public."ramInstallationTypeContents" RENAME TO raminstallationtypecontent;
ALTER TABLE public."skinLicenses" RENAME TO skinlicense;
ALTER TABLE public."skinMaterials" RENAME TO skinmaterial;
ALTER TABLE public.skins RENAME TO skin;
ALTER TABLE public."staOperations" RENAME TO staoperation;
ALTER TABLE public."staOperationServices" RENAME TO staoperationservice;
ALTER TABLE public."staServices" RENAME TO staservice;
ALTER TABLE public."staStations" RENAME TO stastation;
ALTER TABLE public."staStationTypes" RENAME TO stastationtype;
ALTER TABLE public."tntTournamentBannedGroups" RENAME TO tnttournamentbannedgroup;
ALTER TABLE public."tntTournamentBannedTypes" RENAME TO tnttournamentbannedtype;
ALTER TABLE public."tntTournamentGroupPoints" RENAME TO tnttournamentgrouppoint;
ALTER TABLE public."tntTournaments" RENAME TO tnttournament;
ALTER TABLE public."tntTournamentTypePoints" RENAME TO tnttournamenttypepoint;
ALTER TABLE public."warCombatZones" RENAME TO warcombatzone;
ALTER TABLE public."warCombatZoneSystems" RENAME TO warcombatzonesystem;

ALTER TABLE public.mapconstellation RENAME "x_max" TO xmaxf;
ALTER TABLE public.mapconstellation RENAME "x_min" TO xminf;
ALTER TABLE public.mapconstellation RENAME "y_max" TO ymaxf;
ALTER TABLE public.mapconstellation RENAME "y_min" TO yminf;
ALTER TABLE public.mapconstellation RENAME "z_max" TO zmaxf;
ALTER TABLE public.mapconstellation RENAME "z_min" TO zminf;
ALTER TABLE public.mapregion RENAME "x_max" TO xmaxf;
ALTER TABLE public.mapregion RENAME "x_min" TO xminf;
ALTER TABLE public.mapregion RENAME "y_max" TO ymaxf;
ALTER TABLE public.mapregion RENAME "y_min" TO yminf;
ALTER TABLE public.mapregion RENAME "z_max" TO zmaxf;
ALTER TABLE public.mapregion RENAME "z_min" TO zminf;
ALTER TABLE public.mapsolarsystem RENAME "x_max" TO xmaxf;
ALTER TABLE public.mapsolarsystem RENAME "x_min" TO xminf;
ALTER TABLE public.mapsolarsystem RENAME "y_max" TO ymaxf;
ALTER TABLE public.mapsolarsystem RENAME "y_min" TO yminf;
ALTER TABLE public.mapsolarsystem RENAME "z_max" TO zmaxf;
ALTER TABLE public.mapsolarsystem RENAME "z_min" TO zminf;
ALTER TABLE public.mapuniverse RENAME "x_max" TO xmaxf;
ALTER TABLE public.mapuniverse RENAME "x_min" TO xminf;
ALTER TABLE public.mapuniverse RENAME "y_max" TO ymaxf;
ALTER TABLE public.mapuniverse RENAME "y_min" TO yminf;
ALTER TABLE public.mapuniverse RENAME "z_max" TO zmaxf;
ALTER TABLE public.mapuniverse RENAME "z_min" TO zminf;

delete from invname where itemid in (select itemid from invitem where typeid not in (select typeid from invtype))
delete from invitem where typeid not in (select typeid from invtype)
delete from invtypematerial where typeid not in (select typeid from invtype)

ALTER TABLE invname ADD CONSTRAINT fk_invname_itemid FOREIGN KEY (itemid) REFERENCES invitem(itemid);
ALTER TABLE invposition ADD CONSTRAINT fk_invposition_itemid FOREIGN KEY (itemid) REFERENCES invitem(itemid);
ALTER TABLE invitem ADD CONSTRAINT fk_invitem_typeid FOREIGN KEY (typeid) REFERENCES invtype(typeid);
ALTER TABLE dgmtypeattribute ADD CONSTRAINT fk_dgmtypeattribute_typeid FOREIGN KEY (typeid) REFERENCES invtype(typeid);
ALTER TABLE dgmtypeeffect ADD CONSTRAINT fk_dgmtypeeffect_typeid FOREIGN KEY (typeid) REFERENCES invtype(typeid);
ALTER TABLE invtypematerial ADD CONSTRAINT fk_invtypematerial_typeid FOREIGN KEY (typeid) REFERENCES invtype(typeid);
ALTER TABLE invtypematerial ADD CONSTRAINT fk_invtypematerial_materialtypeid FOREIGN KEY (materialtypeid) REFERENCES invtype(typeid);
ALTER TABLE invtypereaction ADD CONSTRAINT fk_invtypereaction_typeid FOREIGN KEY (typeid) REFERENCES invtype(typeid);
ALTER TABLE invtypereaction ADD CONSTRAINT fk_invtypereaction_reactiontypeid FOREIGN KEY (reactiontypeid) REFERENCES invtype(typeid);
ALTER TABLE invitem ADD CONSTRAINT fk_invitem_flagid FOREIGN KEY (flagid) REFERENCES invflag(flagid);
ALTER TABLE mapsolarsystem ADD CONSTRAINT fk_mapsolarsystem_regionid FOREIGN KEY (regionid) REFERENCES mapregion(regionid);


CREATE TABLE public.marketlog
(
  price real not null,
  volremaining bigint not null,
  typeid integer not null,
  range real not null,
  orderid bigint not null,
  volentered bigint not null,
  minvolume integer not null,
  bid boolean not null,
  issuedate timestamp not null,
  lastupdated timestamp not null,
  duration integer not null,
  stationid integer not null,
  regionid integer not null,
  solarsystemid integer not null,
  jumps integer not null,
  CONSTRAINT fk_marketlog_typeid FOREIGN KEY (typeid)
      REFERENCES public.invtype (typeid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.marketlog
  OWNER TO postgres;

CREATE TABLE public.moonmaterial
(
  quantity real not null,
  oretypeid integer not null,
  solarsystemid integer not null,
  planetid integer not null,
  moonid integer not null,
  CONSTRAINT fk_moonmaterial_oretypeid FOREIGN KEY (oretypeid)
      REFERENCES public.invtype (typeid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_moonmaterial_solarsystemid FOREIGN KEY (solarsystemid)
      REFERENCES public.mapsolarsystem (solarsystemid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
  CONSTRAINT fk_moonmaterial_moonid FOREIGN KEY (moonid)
      REFERENCES public.invitem (itemid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.moonmaterial
  OWNER TO postgres;
