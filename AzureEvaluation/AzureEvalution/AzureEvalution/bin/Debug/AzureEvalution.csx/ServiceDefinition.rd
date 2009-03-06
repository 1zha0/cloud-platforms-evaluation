<?xml version="1.0"?>
<serviceModel xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" name="AzureEvalution" generation="1" functional="0" release="0" Id="76ccf89b-8662-4756-bcb7-a42d6509709d" dslVersion="1.2.0.0" xmlns="http://schemas.microsoft.com/dsltools/RDSM">
  <groups>
    <group name="AzureEvalutionGroup" generation="1" functional="0" release="0">
      <componentports>
        <inPort name="HttpIn" protocol="http">
          <inToChannel>
            <lBChannelMoniker name="/AzureEvalution/AzureEvalutionGroup/FELoadBalancerHttpIn" />
          </inToChannel>
        </inPort>
      </componentports>
      <settings>
        <aCS name="WebRoleInstances" defaultValue="[1,1,1]">
          <maps>
            <mapMoniker name="/AzureEvalution/AzureEvalutionGroup/MapWebRoleInstances" />
          </maps>
        </aCS>
      </settings>
      <channels>
        <lBChannel name="FELoadBalancerHttpIn">
          <toPorts>
            <inPortMoniker name="/AzureEvalution/AzureEvalutionGroup/WebRole/HttpIn" />
          </toPorts>
        </lBChannel>
      </channels>
      <maps>
        <map name="MapWebRoleInstances" kind="Identity">
          <setting>
            <sCSPolicyIDMoniker name="/AzureEvalution/AzureEvalutionGroup/WebRoleInstances" />
          </setting>
        </map>
      </maps>
      <components>
        <groupHascomponents>
          <role name="WebRole" generation="1" functional="0" release="0" software="D:\azure\AzureEvalution\AzureEvalution\AzureEvalution\obj\Debug\AzureEvalution_WebRole\" entryPoint="ucruntime" parameters="Microsoft.ServiceHosting.ServiceRuntime.Internal.WebRoleMain" hostingEnvironment="frontend">
            <componentports>
              <inPort name="HttpIn" protocol="http" />
            </componentports>
            <resourcereferences>
              <resourceReference name="EventStore" defaultAmount="[1000,1000,1000]" defaultSticky="false" kind="LogStore" />
            </resourcereferences>
            <eventstreams>
              <eventStream name="Microsoft.ServiceHosting.ServiceRuntime.RoleManager.Critical" kind="Default" severity="Critical" signature="Basic_string" />
              <eventStream name="Microsoft.ServiceHosting.ServiceRuntime.RoleManager.Error" kind="Default" severity="Error" signature="Basic_string" />
              <eventStream name="Critical" kind="Default" severity="Critical" signature="Basic_string" />
              <eventStream name="Error" kind="Default" severity="Error" signature="Basic_string" />
              <eventStream name="Warning" kind="OnDemand" severity="Warning" signature="Basic_string" />
              <eventStream name="Information" kind="OnDemand" severity="Info" signature="Basic_string" />
              <eventStream name="Verbose" kind="OnDemand" severity="Verbose" signature="Basic_string" />
            </eventstreams>
          </role>
          <sCSPolicy>
            <sCSPolicyIDMoniker name="/AzureEvalution/AzureEvalutionGroup/WebRoleInstances" />
          </sCSPolicy>
        </groupHascomponents>
      </components>
      <sCSPolicy>
        <sCSPolicyID name="WebRoleInstances" defaultPolicy="[1,1,1]" />
      </sCSPolicy>
    </group>
  </groups>
  <implements>
    <implementation Id="86cf69d0-38b6-4862-a929-88139fccaa96" ref="Microsoft.RedDog.Contract\ServiceContract\AzureEvalutionContract@ServiceDefinition">
      <interfacereferences>
        <interfaceReference Id="b36ecc2f-7c36-46fe-9312-e5fdca5a08d9" ref="Microsoft.RedDog.Contract\Interface\HttpIn@ServiceDefinition">
          <inPort>
            <inPortMoniker name="/AzureEvalution/AzureEvalutionGroup/HttpIn" />
          </inPort>
        </interfaceReference>
      </interfacereferences>
    </implementation>
  </implements>
</serviceModel>