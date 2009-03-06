using System.Web.Services;
using System;

namespace AzureEvalution_WebRole
{
    /// <summary>
    /// Summary description for GoodDayAzure
    /// </summary>
    [WebService(Namespace = "http://azureva.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class GoodDayAzure : System.Web.Services.WebService
    {
        private ssdsClient.SitkaSoapServiceClient proxy;
        private ssdsClient.Scope scope;
        private DateTime timer;
        private static string INTERNEL_ERROR = "Encounter internal error.";
        private static string NO_RECORD_FOUND = "No record found.";
        private static string KIND = "message";

        private void startTimer()
        {
            timer = DateTime.Now;
        }

        private long getTimer()
        {
            return (DateTime.Now.Ticks - timer.Ticks) / 10000;
        }

        public GoodDayAzure()
        {
            // pre define existed authority and container

            proxy = new ssdsClient.SitkaSoapServiceClient("BasicAuthEndpoint");
            proxy.ClientCredentials.UserName.UserName = "shrimpy";
            proxy.ClientCredentials.UserName.Password = "shrimpy";

            scope = new ssdsClient.Scope();
            scope.AuthorityId = "azureva";
            scope.ContainerId = "container1";
        }

        [WebMethod]
        public Result SayGoodDay(string yourNamePlz)
        {
            // instance back message

            startTimer();
            Result result = new Result();
            result.value = string.Format("Good day {0}", yourNamePlz);
            result.timer = getTimer();
            return result;
        }

        private static string columnName = "message";

        [WebMethod]
        public Result create(string content)
        {
            // insert one message into database, and return
            startTimer();
            Result result = new Result();

            try
            {
                ssdsClient.Entity entity = new ssdsClient.Entity();
                entity.Id = DateTime.Now.Ticks.ToString();
                entity.Kind = KIND;
                entity.Properties = new System.Collections.Generic.Dictionary<string, object>();
                entity.Properties.Add(columnName, content);
                proxy.Create(scope, entity);

                result.value = content;
            }
            catch
            {
                result.value = INTERNEL_ERROR;
            }
            result.timer = getTimer();

            return result;
        }

        [WebMethod]
        public Result read(string key)
        {
            // retrive data base on the key
            startTimer();
            Result result = new Result();

            try
            {
                System.Collections.Generic.List<ssdsClient.Entity> l = proxy.Query(scope,"");

                if (l.Count > 1)
                {
                    result.value = INTERNEL_ERROR;
                }
                else 
                {
                    result.value = NO_RECORD_FOUND;

                }
            }
            catch
            {
                result.value = INTERNEL_ERROR;
            }
            result.timer = getTimer();

            return result;
        }

        [WebMethod]
        public Result update(string key)
        {
            // retrive data base on the key
            return new Result();
        }

        [WebMethod]
        public Result delete(string key)
        {
            // retrive data base on the key
            return new Result();
        }
    }

    public class Result 
    {
        public string value;
        public long timer;
    }

}
