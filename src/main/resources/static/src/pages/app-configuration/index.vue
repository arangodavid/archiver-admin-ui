<!-- 
    TO DO:
	common url api /ui-api/GROUP_NAME/METHOD_NAME (get) && (post)
	app config {3 functions, get all, savelist settings for JSON Object}

	NOTES: 2 ways to catch form erros
	1.) through comments(remove the disbled attribute from input el)
	2.) disabling the save button if not all fields are filled
-->
<template>
    <section>
    	<h1 class="slds-text-heading_large slds-m-bottom_x-large">App Configuration</h1>
    	<section class="primary-section">
    		<section v-show="this.baseSfUrlErrors.length">
    			<p class="errors" 
                    v-for="baseSfUrlError in baseSfUrlErrors"
                >
                    {{baseSfUrlError}}
                </p>
    		</section>
	        <form @submit.prevent="saveBaseSfUrl" class="slds-form-element__form">
	        	<label class="slds-form-element__label">{{ title }}</label>
	    		<input class="slds-form-element__input" type="text" v-model="baseSfUrl"/>
	    		<input class="slds-button slds-button_brand slds-form-element__save" type="submit" value="Save"/>
	    	</form>
    	</section>
    	<h1 class="slds-text-heading_large slds-m-bottom_x-large">SF API credentials</h1>
    	<section class="primary-section">
    		<section v-show="this.credentialErrors.length">
    			<p class="errors" v-for="credentialError in credentialErrors">{{credentialError}}</p>
    		</section>
    		<form @submit.prevent="saveCredentials" class="slds-form-element__form">
    			<label class="slds-form-element__label">Username</label> 
    			<input class="slds-form-element__input" type="text" v-model="username"/>
    			<label class="slds-form-element__label">Password</label>
    			<input class="slds-form-element__input slds-form-element__input__pass" type="text" v-model="password"/>
    			<label class="slds-form-element__label">Token</label>
    			<input class="slds-form-element__input" type="text" v-model="token"/>
    			<input class="slds-button slds-button_brand slds-form-element__save" type="submit" value="Save" />
    		</form>
    	</section>
    </section>
</template>

<script>

    import API from '../../core/api.js';
    import EM from '../../core/event-emitter.js';
    import PageLoader from '../../components/page-loader.vue';

    export default {
    	data() {
    		return {
    			title: 'Base Salesforce URL',
                baseSfUrl: null,
    			username: null,
    			password: null,
    			token: null,
                appCredentials: null,
    			baseSfUrlErrors: [],
    			credentialErrors: []
    		}
    	},
    	methods: {
    		checkBaseSfUrlErrors() {
    			if(this.baseSfUrl) {
    				this.baseSfUrlErrors = [];
                    return false;
    			}else {
    				if(!this.baseSfUrl) this.baseSfUrlErrors.push('Salesforce Base Url Required');
                    return true;
    			}
    		},

    		checkCredentialErrors() {
    			if(this.username && this.password && this.token) {//Checks if all fields are filled out
    				this.credentialErrors = []; //Clears errors
                    return false;
    			}else {
    				if(!this.username) this.credentialErrors.push('Username Required');
					if(!this.password) this.credentialErrors.push('Password Required');
					if(!this.token) this.credentialErrors.push('Token Required');
                    return true;
    			}
    		},

            loadCredentials() { //Receiving access errors status: 500(server error)
                EM.$emit(PageLoader.SHOW);
                API.getAppConfiguration().then(data => {
                    EM.$emit(PageLoader.HIDE);
                    console.log(data);
                    this.appCredentials = data;
                });
            },

            saveBaseSfUrl() {
                if(!this.checkBaseSfUrlErrors()) {
                    EM.$emit(PageLoader.SHOW);
                    let url = this.baseSfUrl;
                    API.saveBaseUrl(url).then(data => {
                        EM.$emit(PageLoader.HIDE);
                        console.log(data);
                    });
                }
            },

    		saveCredentials() {
                if(!this.checkCredentialErrors()) { //Returns false is there are no errors
                    let credentials = { //Saves user credentials
                        username: this.username,
                        password: this.password,
                        token: this.token
                    };
                    EM.$emit(PageLoader.SHOW);
                     API.saveSfUserCredentials(credentials).then(data => {//Post credentials
                        EM.$emit(PageLoader.HIDE);
                        console.log(data);
                    });
                };
    		}
    	},
    	mounted() {
    		// this.loadCredentials();
    	}
    }
</script>

<style scoped>
</style>
