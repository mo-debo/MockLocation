var fakeLocation = {
  check: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'FakeLocation', 'check', []);
  },
  checkEmu: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'FakeLocation', 'checkEmu', []);
}
}

if (!window.plugins) { window.plugins = {}; }

window.plugins.fakeLocation = fakeLocation;
return window.plugins.fakeLocation;