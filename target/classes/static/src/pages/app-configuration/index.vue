<!-- 
	common url api /ui-api/GROUP_NAME/METHOD_NAME 
	object config {navigation.vue, router.js}
	app config {3 functions, get all, savelist settings for JSON Object}

	Note: 2 ways to catch erros
	1.) through comments(remove the disbled attribute from input el)
	2.) disabling the save button if not all fields are filled
-->
<template>
    <div>
    	<h1 class="slds-text-heading_large slds-m-bottom_x-large">App Configuration</h1>
    	<div class="primary-section">
    		<section v-show="this.baseUrlErrors.length">
    			<p v-for="baseUrlError in baseUrlErrors">{{baseUrlError}}</p>
    		</section>
	        <form @submit.prevent="submitUrl" class="slds-form-element__form">
	        	<label class="slds-form-element__label">{{ title }}</label>
	    		<input class="slds-form-element__input" type="text" v-model="baseUrl"/>
	    		<input :disabled="!baseUrl" class="slds-button slds-button_brand slds-form-element__save" type="submit" value="Save"/>
	    	</form>
    	</div>
    	<h1 class="slds-text-heading_large slds-m-bottom_x-large">SF API credentials</h1>
    	<div class="primary-section">
    		<section v-show="this.credentialErrors.length">
    			<p v-for="credentialError in credentialErrors">{{credentialError}}</p>
    		</section>
    		<form @submit.prevent="submitCredentials" class="slds-form-element__form">
    			<label class="slds-form-element__label">Username</label> 
    			<input class="slds-form-element__input" type="text" v-model="username"/>
    			<label class="slds-form-element__label">Password</label>
    			<input class="slds-form-element__input slds-form-element__input__pass" type="text" v-model="password"/>
    			<label class="slds-form-element__label">Token</label>
    			<input class="slds-form-element__input" type="text" v-model="token"/>
    			<input :disabled="!this.username || !this.password || !this.token" class="slds-button slds-button_brand slds-form-element__save" type="submit" value="Save" />
    		</form>
    	</div>
    </div>
</template>

<script>

    import API from '../../core/api.js';
    import EM from '../../core/event-emitter.js';
    import PageLoader from '../../components/page-loader.vue';

    export default {
    	data() {
    		return {
    			title: 'Base Salesforce URL',
    			baseUrl: null,
    			description: null,
    			username: null,
    			password: null,
    			token: null,
    			baseUrlErrors: [],
    			credentialErrors: [],
                appCredentials: null
    		}
    	},
    	methods: {
    		loadCredentials() {
                EM.$emit(PageLoader.SHOW);
                API.getAppConfiguration().then(data => {
                    EM.$emit(PageLoader.HIDE);
                    console.log(data);
                    this.appCredentials = data;
                })
            },
    		checkBaseUrlErrors() {
    			if(this.baseUrl) {
    				this.baseUrlErrors.length = 0;
    				this.baseUrl = null;
    			}else {
    				if(!this.baseUrl) this.baseUrlErrors.push('Salesforce Base Url Required');
    			}
    		},
    		submitUrl() {
    			this.checkBaseUrlErrors();
    		},
    		checkCredentialErrors() {
    			if(this.username && this.password && this.token) {
    				this.credentialErrors.length = 0;
    				this.username = null;
    				this.password = null;
    				this.token = null;
    			}else {
    				if(!this.username) this.credentialErrors.push('Username Required');
					if(!this.password) this.credentialErrors.push('Password Required');
					if(!this.token) this.credentialErrors.push('Token Required');
    			}
    		},
    		submitCredentials() {
    			this.checkCredentialErrors();
    		}
    	},
    	mounted() {
    		this.loadCredentials();
    	}
    }
</script>

<style scoped>
</style>
